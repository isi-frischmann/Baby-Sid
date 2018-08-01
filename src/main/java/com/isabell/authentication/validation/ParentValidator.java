package com.isabell.authentication.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.isabell.authentication.models.Parent;

@Component
public class ParentValidator implements Validator {
    
    // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return Parent.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        Parent parent = (Parent) target;
        
        if (!parent.getPasswordConfirmation().equals(parent.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}
