package com.example.SpringFeatures.APIBeans;



import lombok.Data;

import java.time.LocalDateTime;
import java.util.Locale;

@Data
public class  GenericAPIResponse <T>{

    private T data;
    private ErrorResponse error;
    private LocalDateTime timeStamp;

    public GenericAPIResponse() {

        this.timeStamp = LocalDateTime.now();
    }

    public GenericAPIResponse(T data) {
        this();
        this.data = data;
    }
    public GenericAPIResponse(ErrorResponse errorResponse) {
        this();
        this.error = errorResponse;
    }
}
