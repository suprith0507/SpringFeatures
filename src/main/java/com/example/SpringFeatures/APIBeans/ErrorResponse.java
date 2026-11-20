package com.example.SpringFeatures.APIBeans;



import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data     //equivalent to @getter @setter @argsconstructor @hascodeandequals @tostring
@Builder  //to enable builder pattern way of building the objects instead of conventional new keyword and setters approach
public class ErrorResponse {

    private String message;
    private HttpStatus statusCode;
    private LocalDateTime timeStamp;
}
