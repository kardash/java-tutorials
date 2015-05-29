package com.addressbook.dao;

import java.util.List;

import com.addressbook.entities.Person;

public interface PersonDao {
	public void save(Person p);

	public List<Person> getList();
}
