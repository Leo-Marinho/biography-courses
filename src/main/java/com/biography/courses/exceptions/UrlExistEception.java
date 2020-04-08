package com.biography.courses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UrlExistEception extends RuntimeException {

    public UrlExistEception(String message) {
        super(message);
    }
}
