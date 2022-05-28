package com.capgi.NewSpringBoot.exception;

public class InvalidDateException extends RuntimeException {

    public InvalidDateException(String message){
        super(message);
    }
}