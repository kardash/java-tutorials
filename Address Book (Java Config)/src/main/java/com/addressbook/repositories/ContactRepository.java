package com.addressbook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.addressbook.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
	
	 @Query("select c from Contact c where c.person_id = ?1")
	 List<Contact> listContactsByPerson(String id);
}
