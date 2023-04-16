package com.springbootbasic.exception;

import com.springbootbasic.entity.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionMessage employeeNotFoundHandler(EmployeeNotFoundException exception){

       /* ExceptionMessage message = new ExceptionMessage(HttpStatus.NOT_FOUND,exception.getMessage());

        return message;*/
        return new ExceptionMessage(HttpStatus.NOT_FOUND,exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionMessage genericExceptionHandler(Exception exception){

       /* ExceptionMessage message = new ExceptionMessage(HttpStatus.NOT_FOUND,exception.getMessage());

        return message;*/
        return new ExceptionMessage(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
    }


}
