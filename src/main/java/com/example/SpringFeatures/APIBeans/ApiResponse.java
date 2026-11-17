package com.example.SpringFeatures.APIBeans;

import com.example.SpringFeatures.dtos.ProductDTO;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public class ApiResponse<T> {

    private T data;
    private APIError apiError;
    private LocalDateTime timestamp;


    public ApiResponse(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public ApiResponse(T data ) {
        super();
        this.data = data;


    }

    public ApiResponse( APIError apiError) {
        super();
        this.apiError = apiError;

    }
}
