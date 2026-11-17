package com.example.SpringFeatures.exceptions;

public class CustomResourceNotFoundException  extends RuntimeException{
    public CustomResourceNotFoundException(String message) {
        super(message);
    }
}
