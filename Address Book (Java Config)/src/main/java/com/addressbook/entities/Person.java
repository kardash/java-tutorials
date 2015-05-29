package com.addressbook.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person extends AbstractEntity{

	@Column(name="lastname")
	private String lastname;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="middlename")
	private String middlename;
	
	@Column(name="suffix")
	private String suffix;
	
	@Column(name="prefix")
	private String prefix;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="birthdate")
	private String birthdate;
	
	@Column(name="age")
	private int age;
	
	@OneToMany(cascade= CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name="person_id")
	private List<Contact> contacts;
	
	public Person(){}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getMiddlename() {
		return middlename;
	}
	
	public String getSuffix() {
		return suffix;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public String getBirthdate() {
		return birthdate;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String toString(){
		return "";
	}
}
