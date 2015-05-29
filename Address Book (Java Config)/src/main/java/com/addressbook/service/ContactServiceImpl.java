package com.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.addressbook.components.TestComponent;
import com.addressbook.entities.Contact;
import com.addressbook.repositories.ContactRepository;

public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private TestComponent testComponent;
	
	public void setTestComponent(TestComponent testComponent) {
		this.testComponent = testComponent;
	}
	
	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	public void addContact(Contact c) {
		this.contactRepository.save(c);
	}

	public void updateContact(Contact c) {
		this.contactRepository.saveAndFlush(c);
	}

	public List<Contact> listContactsByPerson(String id) {
		return this.contactRepository.listContactsByPerson(id);
	}

	public Contact getContactById(String id) {
		return this.contactRepository.findOne(id);
	}

	public void removeContact(String id) {
		this.contactRepository.delete(id);
	}

	public String testMethod() {
		return testComponent.toString();
	}
}
