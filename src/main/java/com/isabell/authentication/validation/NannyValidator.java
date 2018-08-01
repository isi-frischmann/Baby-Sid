package com.isabell.authentication.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.isabell.authentication.models.Nanny;

@Component
public class NannyValidator implements Validator{
	
	//1
	@Override
	public boolean supports(Class<?> clazz) {
		return Nanny.class.equals(clazz);
	}
	
	//2
	@Override
	public void validate(Object target, Errors errors) {
		Nanny nanny = (Nanny) target;
		
		if (!nanny.getPasswordConfirmation().equals(nanny.getPassword())) {
			//3
			errors.rejectValue("passwordConfirmation", "Match");
		}
	}
}
