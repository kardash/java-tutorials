package com.addressbook.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.addressbook.entities.Person;

public class PersonValidator implements Validator{

	public boolean supports(Class<?> aClass) {
		return Person.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		Person person = (Person) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "field.required", "Last Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "field.required", "First Name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "field.required", "Age is required.");
		
		//If age is filled out, check if non zero
		if ( ! errors.hasFieldErrors("age")) {
			if (Integer.valueOf(person.getAge()) == 0)
				errors.rejectValue("age", "not_zero", "Age must be greater than zero.");
		}		
	}

}
