package com.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addressbook.components.TestComponent;
import com.addressbook.entities.Contact;
import com.addressbook.entities.Person;
import com.addressbook.repositories.PersonRepository;
  
@Service
public class PersonServiceImpl implements PersonService {
     
    private PersonRepository personRepository;
	private TestComponent testComponent;
    
	@Autowired
	public void setTestComponent(TestComponent testComponent) {
		this.testComponent = testComponent;
	}
	
    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

    @Transactional
    public void addPerson(Person p) {
       this.personRepository.save(p);
    }
 
    @Transactional
    public void updatePerson(Person p) {
       this.personRepository.saveAndFlush(p);
    }
 
    @Transactional
    public List<Person> listPersons() {
        return this.personRepository.findAll();
    }
 
	@Transactional
    public Person getPersonById(String id) {
        return this.personRepository.findOne(id);
    }
 
    @Transactional
    public void removePerson(String id) {
        this.personRepository.delete(id);
    }
    
    @Transactional
    public String testMethod(){
    	return testComponent.toString();
    }
}