// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.oreilly.springdata.roo.domain;

import com.oreilly.springdata.roo.domain.Address;
import com.oreilly.springdata.roo.domain.Customer;
import com.oreilly.springdata.roo.domain.EmailAddress;
import java.util.Set;

privileged aspect Customer_Roo_JavaBean {
    
    public String Customer.getFirstName() {
        return this.firstName;
    }
    
    public void Customer.setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String Customer.getLastName() {
        return this.lastName;
    }
    
    public void Customer.setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public EmailAddress Customer.getEmailAddress() {
        return this.emailAddress;
    }
    
    public void Customer.setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public Set<Address> Customer.getAddresses() {
        return this.addresses;
    }
    
    public void Customer.setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
    
}
