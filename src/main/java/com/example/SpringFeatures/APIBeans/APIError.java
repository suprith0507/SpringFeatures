package com.example.SpringFeatures.APIBeans;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class APIError {

    private HttpStatus errorCode;
    private String errorMessage;

}
