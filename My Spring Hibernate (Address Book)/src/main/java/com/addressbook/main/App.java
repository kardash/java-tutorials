package com.addressbook.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.addressbook.dao.ContactDao;
import com.addressbook.dao.PersonDao;
import com.addressbook.entities.Contact;
import com.addressbook.entities.Person;

public class App {
	
	private static ClassPathXmlApplicationContext context;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDao personDao = context.getBean(PersonDao.class);
		ContactDao contactDao = context.getBean(ContactDao.class);
		
		//Create the person
		Person person = new Person();
		person.setId(UUID.randomUUID().toString());
		person.setFirstname("Hanna Samantha");
		person.setMiddlename("Narciso");
		person.setLastname("Lising");
		person.setAge(7);
		person.setBirthdate("2007-06-19");
		person.setGender("Female");
		
		//Create the contacts	
		Contact contactOne = new Contact(UUID.randomUUID().toString(), "09232104978",
				"09232104978", "Home", "Yes", "j_lising@yahoo.com");
		
		Contact contactTwo = new Contact(UUID.randomUUID().toString(), "09232104978",
				"09232104978", "Work", "Yes", "jlising@owens.com");
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contactOne);
		contacts.add(contactTwo);
		
		//Set each contact to person
		contactOne.setPerson(person);
		contactTwo.setPerson(person);
		
		//Save person in the session
		personDao.save(person);
		
		//Save each contact in the session
		contactDao.save(contactOne);
		contactDao.save(contactTwo);
		
		//List<Person> list = personDao.getList();
		
		//for(Person p : list){
		//	System.out.println("Person List::"+p);
		//}
	}
}
