package com.example.SpringFeatures.Annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomNameValidatorClass.class)
public @interface NameCheckerAnnotation {
    String message() default "Product name must start with Amazon";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
