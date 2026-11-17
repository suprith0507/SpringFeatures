package com.example.SpringFeatures.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomNameValidatorClass implements ConstraintValidator<NameCheckerAnnotation,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.startsWith("Amazon")) return true; else return false;
    }
}
