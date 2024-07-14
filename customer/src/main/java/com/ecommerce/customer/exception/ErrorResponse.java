package com.ecommerce.customer.exception;

import lombok.Data;

import java.util.Map;

@Data
public class ErrorResponse {

    Map<String, String> errors;

    public ErrorResponse(Map<String, String> errors) {

    }
}
