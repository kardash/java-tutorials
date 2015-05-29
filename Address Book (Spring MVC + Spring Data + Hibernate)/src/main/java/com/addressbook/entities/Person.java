package com.addressbook.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@Column(name = "id", unique = true)
	private String id;
	
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
	private String gender;
	
	@Column(name="birthdate")
	private String birthdate;
	
	@Column(name="age")
	private int age;

	public Person(){}
	
	public String getId() {
		return id;
	}
	
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
	
	public String getGender() {
		return gender;
	}
	
	public String getBirthdate() {
		return birthdate;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public String toString(){
		return "";
	}
}
