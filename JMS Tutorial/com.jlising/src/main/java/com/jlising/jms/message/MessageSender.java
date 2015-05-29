package com.jlising.jms.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class MessageSender {
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void send(final Object Object) {
		jmsTemplate.convertAndSend(Object);
	}
}
