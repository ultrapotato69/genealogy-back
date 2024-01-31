package com.example.genealogyback.exception;

public class NonUniqueEntityException extends RuntimeException {
    public NonUniqueEntityException(String message) {
        super(String.join(" ", "Not a unique entity.", message));
    }
}
