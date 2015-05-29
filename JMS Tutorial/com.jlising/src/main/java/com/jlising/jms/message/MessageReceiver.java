package com.jlising.jms.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MessageReceiver {
	private final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);
	
	public String handleMessage(String text) {
	    logger.info("Received: " + text);
	    return "ACK from handleMessage";
	  }
}
