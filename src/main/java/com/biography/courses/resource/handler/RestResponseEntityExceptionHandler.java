package com.biography.courses.resource.handler;

import com.biography.courses.exceptions.StatusNullInvalidException;
import com.biography.courses.exceptions.UrlExistEception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StatusNullInvalidException.class)
    public final ResponseEntity<Object> handleStatusNullInvalidExcepiton(final StatusNullInvalidException ex, final WebRequest request){
        final ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UrlExistEception.class)
    public final ResponseEntity<Object> handleUrlExistExcepiton(final UrlExistEception ex, final WebRequest request){
        final ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
