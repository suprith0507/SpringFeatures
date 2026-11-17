package com.example.SpringFeatures.APIBeans;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class APIError {

    private String errorCode;
    private String errorMessage;

}
