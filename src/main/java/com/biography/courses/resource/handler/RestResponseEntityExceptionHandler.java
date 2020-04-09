package com.biography.courses.resource.handler;

import com.biography.courses.exceptions.StatusCourseInvalidException;
import com.biography.courses.exceptions.UrlExistException;
import com.biography.courses.exceptions.NoCoursesFoundWithThisNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleStatusNullInvalidExcepiton(final ConstraintViolationException ex, final WebRequest request){
        final ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UrlExistException.class)
    public final ResponseEntity<Object> handleUrlExistException(final UrlExistException ex, final WebRequest request){
        final ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoCoursesFoundWithThisNameException.class)
    public final ResponseEntity<Object> handleNoCoursesException(final NoCoursesFoundWithThisNameException ex, final WebRequest request){
        final ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StatusCourseInvalidException.class)
    public final ResponseEntity<Object> handleStatusCourseInvalidException(final StatusCourseInvalidException ex, final WebRequest request){
        final ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
