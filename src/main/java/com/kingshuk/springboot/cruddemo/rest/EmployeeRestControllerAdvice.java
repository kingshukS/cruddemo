package com.kingshuk.springboot.cruddemo.rest;

import com.kingshuk.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.kingshuk.springboot.cruddemo.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class EmployeeRestControllerAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException ex, WebRequest request){
        ErrorResponse error = new ErrorResponse(ex.getMessage(),ex.getStatus(), ex.getDescription());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}