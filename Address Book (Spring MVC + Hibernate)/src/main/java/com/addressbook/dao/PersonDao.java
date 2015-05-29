package com.addressbook.dao;

import java.util.List;

import com.addressbook.entities.Person;
public interface PersonDao {
    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(String id);
    public void removePerson(String id);
}