package com.example.SpringFeatures.APIBeans;

import com.example.SpringFeatures.dtos.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor

@Builder

public class ApiResponse<T> {

    private T data;
    private APIError apiError;
    private LocalDateTime timestamp;


    public ApiResponse()
    {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(T data ) {
        this();
        this.data = data;


    }

    public ApiResponse( APIError apiError) {
        this();
        this.apiError = apiError;

    }
}
