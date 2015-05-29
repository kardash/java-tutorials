package com.addressbook.service;

import java.util.List;

import com.addressbook.entities.Contact;

public interface ContactService {
 	public void addContact(Contact c);
    public void updateContact(Contact c);
    public List<Contact> listContactsByPerson(String id);
    public Contact getContactById(String id);
    public void removeContact(String id);
    public String testMethod();
}
