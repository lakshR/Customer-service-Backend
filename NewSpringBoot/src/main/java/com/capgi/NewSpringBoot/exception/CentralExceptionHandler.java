package com.capgi.NewSpringBoot.exception;


import com.capgi.NewSpringBoot.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class CentralExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(CustomerNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e){

        String message = e.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(","));
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> invalidDate(InvalidDateException e){
        return new ResponseEntity<>("Date is greater than that of today, please enter correct date", HttpStatus.NOT_FOUND);
    }
}