package com.addressbook.service;

import java.util.List;

import com.addressbook.entities.Person;

public interface PersonService {

    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(String id);
    public void removePerson(String id);
    public String testMethod();
}