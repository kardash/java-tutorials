package com.addressbook.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addressbook.dao.PersonDao;
import com.addressbook.entities.Person;
  
@Service
public class PersonServiceImpl implements PersonService {
     
    private PersonDao personDao;
 
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
 
    @Transactional
    public void addPerson(Person p) {
        this.personDao.addPerson(p);
    }
 
    @Transactional
    public void updatePerson(Person p) {
        this.personDao.updatePerson(p);
    }
 
    @Transactional
    public List<Person> listPersons() {
        return this.personDao.listPersons();
    }
 
    @Transactional
    public Person getPersonById(String id) {
        return this.personDao.getPersonById(id);
    }
 
    @Transactional
    public void removePerson(String id) {
        this.personDao.removePerson(id);
    }
}