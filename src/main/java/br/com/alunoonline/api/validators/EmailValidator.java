package br.com.alunoonline.api.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements
        ConstraintValidator<EmailValidation, String> {

    private String message;

    @Override
    public void initialize(EmailValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
       if(email.contains("@fuji.com")){
           return true;
       }
       constraintValidatorContext.disableDefaultConstraintViolation();
       constraintValidatorContext.buildConstraintViolationWithTemplate(
               message + email
       ).addConstraintViolation();

        return false;
    }
}
