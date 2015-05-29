package com.jdechmann.proto.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.jdechmann.proto.camel.vo.Candidate;

/**
 * Process a Candidate object
 * Throw an exception if the candidate does not
 * match the criteria
 * 
 * @author Julien Dechmann
 *
 */
public class CandidateProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Candidate candidate = exchange.getIn().getBody(Candidate.class);
		
		if(candidate.getAge() > 60 || candidate.getSize() < 160)
			throw new Exception("Candidate refused " + candidate.toString());
		else
			System.out.println("Candidate accepted " + candidate.toString());
	}

}
