package com.jdechmann.proto.camel.route;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import com.jdechmann.proto.camel.processor.CandidateProcessor;
import com.jdechmann.proto.camel.vo.Candidate;
import com.thoughtworks.xstream.XStream;

public class CandidateRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		XStream xstream = new XStream();
		xstream.processAnnotations(Candidate.class);
		
		XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
		xStreamDataFormat.setXStream(xstream);
		
		//Intercept the exceptions
		onException(Exception.class)
		.handled(true)
		//Convert the object to XML
		.marshal(xStreamDataFormat)
		//Send the result to a JMS queue
		.to("jms:queue.candidate.rejected");
		
		//Consume from CSV files
		from("file:src/test/resources/?fileName=testfile.csv")
		//Unmarshal CSV files. The resulting message contains a List<List<String>>
		.unmarshal().csv()
		//Split the message into a number of pieces 
		.split(body(List.class))
		//Convert the message into a Person object
		.convertBodyTo(Candidate.class)
		//Process the candidates
		.process(new CandidateProcessor())
		//Convert the object to XML
		.marshal(xStreamDataFormat)
		//Send the result to a JMS queue
		.to("jms:queue.candidate.selected");

	}

}
