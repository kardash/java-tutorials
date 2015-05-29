package com.addressbook.entities;

public class Address {
	private String id;
	private String address1, address2, city, state, zip, type;
	
	private Person person;
	private Country country;
	
	public String getId() {
		return id;
	}

	public String getAddress1() {
		return address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public String getType() {
		return type;
	}

	public Person getPerson() {
		return person;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}	
	
	public String toString(){
		return "";
	}
}
