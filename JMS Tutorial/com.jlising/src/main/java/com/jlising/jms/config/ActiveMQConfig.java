package com.jlising.jms.config;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import com.jlising.jms.message.MessageReceiver;
import com.jlising.jms.message.MessageSender;

@Configuration
public class ActiveMQConfig {

	@Bean
	ActiveMQConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL("tcp://localhost:61616");
		
		return factory;
	}
	
	@Bean
	JmsTemplate jmsTemplate (){
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestination(destination());
		
		return template;
	}
	
	@Bean
	ActiveMQQueue destination(){
		return  new ActiveMQQueue("MyQueue");
	}
	
	@Bean
	MessageSender messageSender(){
		return new MessageSender();
	}
	
	@Bean
	DefaultMessageListenerContainer messageListenerContainer(){
		DefaultMessageListenerContainer listener = new DefaultMessageListenerContainer();
		listener.setConnectionFactory(connectionFactory());
		listener.setDestinationName("MyQueue");
		listener.setMessageListener(messageListenerAdapter());
		
		return listener;
	}
	
	@Bean
	MessageReceiver messageListener(){
		return new MessageReceiver();
	}
	
	@Bean
	MessageListenerAdapter messageListenerAdapter(){
		MessageListenerAdapter adapter = new MessageListenerAdapter(messageListener());
		
		return adapter;
	}
	
	@Bean 
	BrokerService brokerService(){
		BrokerService broker = new BrokerService();
		// configure the broker
		broker.setBrokerName("fred");
		
		try {
			broker.addConnector("tcp://localhost:61616");
			broker.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return broker;
	}
}
