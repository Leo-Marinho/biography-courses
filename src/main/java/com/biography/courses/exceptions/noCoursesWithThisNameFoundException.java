package com.biography.courses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class noCoursesWithThisNameFoundException extends RuntimeException {

    public noCoursesWithThisNameFoundException(final String message) {
        super(message);
    }
}
