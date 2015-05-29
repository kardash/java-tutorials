package com.addressbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.addressbook.components.TestComponent;
import com.addressbook.service.ContactService;
import com.addressbook.service.ContactServiceImpl;
import com.addressbook.service.PersonService;
import com.addressbook.service.PersonServiceImpl;
import com.addressbook.validators.PersonValidator;

@Configuration
public class ServiceConfig {
	
	@Bean(name="personService")
    public PersonService personService() {
    	return new PersonServiceImpl();
    }
	
	@Bean(name="contactService")
    public ContactService contactService() {
    	return new ContactServiceImpl();
    }
	
	@Bean(name="testComponent")
	public TestComponent testComponent(){
		return new TestComponent();
	}
	
	@Bean(name="personValidator")
	public PersonValidator personValidator(){
		return new PersonValidator();
	}
}
