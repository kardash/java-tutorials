package com.addressbook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT")
public class Contact extends AbstractEntity{

	@Column(name="mobile_no")
	private String mobile_no;
	
	@Column(name="phone_no")
	private String phone_no;
	
	@Column(name="type")
	private String type;
	
	@Column(name="primary")
	private String primary;
	
	@Column(name="email")
	private String email;
	
	@Column(name= "person_id", insertable=false, updatable=false)
	private String person_id;
	
	@ManyToOne
	@JoinColumn
	private Person person;
	
	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public Contact(){}

	public String getMobile_no() {
		return mobile_no;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public String getType() {
		return type;
	}

	public String getPrimary() {
		return primary;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
