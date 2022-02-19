package com.example.library.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Hashtable;
import java.util.List;

public class UpperCaseConstraintValidator implements ConstraintValidator<UpperCase, String> {
    @Override
    public void initialize(UpperCase constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String firstSymbol = s.substring(0, 1);
        return firstSymbol.equals(firstSymbol.toUpperCase());
    }
}