package com.addressbook.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.addressbook.entities.Contact;
import com.addressbook.entities.Person;
import com.addressbook.service.ContactService;
import com.addressbook.service.PersonService;

@Controller
public class ContactController {
	
	private final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private PersonService personService;
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@RequestMapping(value = "/person/{id}/contacts", method = RequestMethod.GET)
    public String listContacts(Model model, @PathVariable("id") String id) {
    
    	Person person = this.personService.getPersonById(id);
		Contact contact = new Contact();
		
		contact.setPerson(person);
		
		contact.setPerson_id(person.getId());
		
		logger.info("Adding contact attribute");
        model.addAttribute("contact", contact);
        model.addAttribute("listContacts", this.contactService.listContactsByPerson(id));
               
        return "contact";
    }
	
    @RequestMapping(value= "/person/add-contact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact){
    	
    	logger.info("Set the person id of the contact");
    	contact.setPerson(this.personService.getPersonById(contact.getPerson_id()));
    	
    	this.contactService.addContact(contact);      
    	
    	return "redirect:/person/" +contact.getPerson_id() + "/contacts";
    }
    
    @RequestMapping("/contact/remove/{id}")
    public String removeContact(@PathVariable("id") String id){
    	logger.info("Removing contact " + id); 
    	
    	Contact contact = this.contactService.getContactById(id);
    	
        this.contactService.removeContact(id);
        
        return "redirect:/person/" +contact.getPerson_id() + "/contacts";
    }
  
    @RequestMapping("/contact/edit/{id}")
    public String editContact(Model model, @PathVariable("id") String id){
    	logger.info("Adding existing contact in attribute");
        
    	Contact contact = this.contactService.getContactById(id);
    	model.addAttribute("contact", contact);
        
        logger.info("Adding listContacts attribute");
        model.addAttribute("listContacts", this.contactService.listContactsByPerson(contact.getPerson_id()));
       
        return "contact";
    }
    
    @ModelAttribute
    public Model getPrimaryList(Model model){
    	 List<String> primaryList = new ArrayList<String>();
    	 primaryList.add("Yes");
    	 primaryList.add("No");
    	 
    	 model.addAttribute("primaryList", primaryList);
    	 
    	 return model;
    }
}
