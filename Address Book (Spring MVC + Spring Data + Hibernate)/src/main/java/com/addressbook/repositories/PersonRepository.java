package com.addressbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addressbook.entities.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

}
