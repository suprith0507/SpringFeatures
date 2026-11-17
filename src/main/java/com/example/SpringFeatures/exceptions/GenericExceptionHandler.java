package com.example.SpringFeatures.exceptions;

import com.example.SpringFeatures.APIBeans.APIError;
import com.example.SpringFeatures.APIBeans.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(CustomResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(CustomResourceNotFoundException exp)
    {
        APIError apiError =APIError.builder().errorCode(HttpStatus.NOT_FOUND).errorMessage(exp.getLocalizedMessage()).build();
        return new  ResponseEntity<>( new ApiResponse(apiError),HttpStatus.NOT_FOUND);
    }
}
