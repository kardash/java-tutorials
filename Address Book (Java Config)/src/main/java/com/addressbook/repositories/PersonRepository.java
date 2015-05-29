package com.addressbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addressbook.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

}
