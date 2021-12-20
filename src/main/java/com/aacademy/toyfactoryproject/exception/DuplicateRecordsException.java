package com.aacademy.toyfactoryproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateRecordsException extends RuntimeException{

    public DuplicateRecordsException(String message) {
        super(message);
    }
}
