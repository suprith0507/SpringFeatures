package com.example.SpringFeatures.exceptions;

import com.example.SpringFeatures.APIBeans.APIError;
import com.example.SpringFeatures.APIBeans.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(CustomResourceNotFoundException.class)
    public ApiResponse handleResourceNotFoundException(CustomResourceNotFoundException exp)
    {
        APIError apiError =APIError.builder().errorCode(String.valueOf(HttpStatus.NOT_FOUND)).errorMessage(exp.getLocalizedMessage()).build();
        return new ApiResponse(apiError);
    }
}
