package com.addressbook.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.addressbook.entities.Gender;
import com.addressbook.entities.Person;
import com.addressbook.service.PersonService;

@Controller
public class PersonController {
	private final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	@Qualifier("personValidator")
	Validator validator;
	
	@Autowired(required=true)
	private PersonService personService;
	
    public void setPersonService(@Qualifier(value="personService") PersonService ps){
        this.personService = ps;
    }
     
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
    	logger.info("Adding person attribute with new Person()");
    	
        model.addAttribute("person", new Person());
        
        logger.info("Adding listPersons attribute");
        //model.addAttribute("listPersons", this.personService.listPersons());
        //model.addAttribute("genderList", Gender.values());
        
        return "person";
    }
     
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") @Validated Person p, BindingResult bindingResult){
    	
    	if(bindingResult.hasErrors()){
    		logger.info("Return to form.");
    		return "person";
    	}
    	
        if(p.getId() == null){
        	logger.info("Adding new record for person");
            this.personService.addPerson(p);
        }else{
        	logger.info("Updating existing person");
            this.personService.updatePerson(p);
        }
        
        return "redirect:/persons";
    }
     
    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") String id){
    	logger.info("Removing person " + id); 
        this.personService.removePerson(id);
       
        return "redirect:/persons";
    }
  
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPerson(@PathVariable("id") String id, Model model){
    	logger.info("Adding existing person in attribute");
        model.addAttribute("person", this.personService.getPersonById(id));
        
        logger.info("Adding listPersons attribute");
        //model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
    
    @ModelAttribute("listAttributes")
    public Model listAttributes(Model model){
    	
    	model.addAttribute("listPersons",this.personService.listPersons());
    	model.addAttribute("genderList", Gender.values());
    	
    	return model;
    }
}