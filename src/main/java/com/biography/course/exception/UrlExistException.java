package com.biography.course.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UrlExistException extends RuntimeException {

    public UrlExistException(final String message) {
        super(message);
    }
}
