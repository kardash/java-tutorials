package com.addressbook.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact")
@Embeddable
public class Contact {
	
	@Id
	@Column(name="id")
	private String id;
	
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
		
	@ManyToOne
	private Person person;
			
	public Contact(String id, String mobile_no, String phone_no, String type,
			String primary, String email) {
		this.id = id;
		this.mobile_no = mobile_no;
		this.phone_no = phone_no;
		this.type = type;
		this.primary = primary;
		this.email = email;
	}

	public String getId() {
		return id;
	}

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

	public void setId(String id) {
		this.id = id;
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
