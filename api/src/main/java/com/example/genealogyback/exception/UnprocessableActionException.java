package com.example.genealogyback.exception;

public class UnprocessableActionException extends RuntimeException{
    public UnprocessableActionException(String message) {
        super(message);
    }
}
