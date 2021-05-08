package com.nagarro.nagp.assignment.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, int value) {
        super(String.format("No %s found for id: %s", resourceName, value));
    }
    public ResourceNotFoundException(String resourceName, int value, String message) {
        super(String.format("Not able to fetch %s found for id: %s, %s", resourceName, value, message));
    }
}
