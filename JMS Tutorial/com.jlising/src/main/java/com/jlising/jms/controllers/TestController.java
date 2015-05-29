package com.jlising.jms.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jlising.jms.message.MessageSender;

@Controller
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	MessageSender messageSender;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(Model model) {
    	logger.info("test");
    	
    	Map message = new HashMap();
    	
    	message.put("Hello", "World");
    	message.put("country", "India");
    	message.put("state", "Maharashtra");
    	message.put("city", "Pune");

    	messageSender.send(message);
    	  
    	logger.info("Message Send to Jms Queue:- " + message) ;
        
        return "test";
    }
}
