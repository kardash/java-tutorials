package com.addressbook.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.addressbook.config.DataConfig;
import com.addressbook.config.ServiceConfig;
import com.addressbook.entities.Contact;
import com.addressbook.entities.Gender;
import com.addressbook.entities.Person;
import com.addressbook.service.ContactService;
import com.addressbook.service.PersonService;

public class PersonTest {
	
	ApplicationContext context;
	PersonService personService;
	ContactService contactService;
	
	@Before
	public void setUp(){
		context = new AnnotationConfigApplicationContext(DataConfig.class, ServiceConfig.class);
		personService = (PersonService) context.getBean("personService");
		contactService = (ContactService) context.getBean("contactService");
	} 
	
	/**
	 * Test adding person with contacts
	 */
	@Test
	public void test1() {
		Person p = new Person();
		
		p.setFirstname("Jesus");
		p.setMiddlename("Pangan");
		p.setLastname("Lising");
		p.setAge(34);
		p.setBirthdate("1980-12-25");
		p.setGender(Gender.MALE);
		p.setPrefix("Mr.");
		
		Contact c = new Contact();
		c.setEmail("jlising@owens.com");
		c.setMobile_no("0923-2104-978");
		c.setPhone_no("0923-2104-978");
		c.setPrimary("Yes");
		c.setType("Work");
		c.setPerson(p);
		
		//p.setContacts(new ArrayList<Contact>());
		//p.getContacts().add(c);
		
		personService.addPerson(p);
		assert(true);
	}
	
	/**
	 * Test adding of each separate entity
	 */
	@Test
	public void test2(){
		Person p = new Person();
		
		p.setFirstname("Jesus");
		p.setMiddlename("Pangan");
		p.setLastname("Lising");
		p.setAge(34);
		p.setBirthdate("1980-12-25");
		p.setGender(Gender.MALE);
		p.setPrefix("Mr.");
		
		personService.addPerson(p);
		
		Contact c = new Contact();
		c.setEmail("jlising@owens.com");
		c.setMobile_no("0923-2104-978");
		c.setPhone_no("0923-2104-978");
		c.setPrimary("Yes");
		c.setType("Work");
		//c.setPerson(p);
		c.setPerson_id(p.getId());
		
		contactService.addContact(c);
		assert(true);
	}
	
	/**
	 * Test adding of each separate entity
	 */
	@Test
	public void test3(){
		Person p = new Person();
		
		p.setFirstname("Jesus");
		p.setMiddlename("Pangan");
		p.setLastname("Lising");
		p.setAge(34);
		p.setBirthdate("1980-12-25");
		p.setGender(Gender.MALE);
		p.setPrefix("Mr.");
		
		personService.addPerson(p);
		
		Contact c = new Contact();
		c.setEmail("jlising@owens.com");
		c.setMobile_no("0923-2104-978");
		c.setPhone_no("0923-2104-978");
		c.setPrimary("Yes");
		c.setType("Work");
		c.setPerson(p);
		c.setPerson(p);
		
		contactService.addContact(c);
		assert(true);
	}
	
	@Test
	public void test4(){
		List<Person> listPersons = personService.listPersons();
		
		assert(true);
	}
}
