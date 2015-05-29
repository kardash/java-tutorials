package com.jdechmann.proto.camel;

import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 
		 CamelContext camel = (CamelContext) context.getBean("camel");
		 camel.start();
	}
}
