package com.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    /*@ExceptionHandler(RuntimeException.class)
    public ErrorMessage onRuntimeException(RuntimeException exception){
    }*/

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail onRuntimeException(RuntimeException exception){
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,exception.getLocalizedMessage());
        return problemDetail;
    }

}
