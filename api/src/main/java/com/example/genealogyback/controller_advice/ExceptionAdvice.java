package com.example.genealogyback.controller_advice;

import com.example.genealogyback.dto.ErrorDto;
import com.example.genealogyback.exception.NoSuchResourceException;
import com.example.genealogyback.exception.NonUniqueEntityException;
import com.example.genealogyback.exception.UndefinedRepoException;
import com.example.genealogyback.exception.UnprocessableActionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDto>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorDto> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorDto("VALIDATION_ERROR",
                        error.getField() + " : " + error.getDefaultMessage()))
                .toList();
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoSuchResourceException.class})
    public ResponseEntity<?> handleNotFoundException(RuntimeException e) {
        log.info("Exception '{}' is handled. Message: '{}'.",
                e.getClass().getName(),
                e.getMessage());
        ErrorDto errors = new ErrorDto("NO_SUCH_RESOURCE_ERROR", e.getMessage());
        return new ResponseEntity<>(List.of(errors), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NonUniqueEntityException.class, UnprocessableActionException.class})
    public ResponseEntity<?> handleBadRequests(RuntimeException e) {
        log.info("Exception '{}' is handled. Message: '{}'.",
                e.getClass().getName(),
                e.getMessage());
        e.printStackTrace();
        ErrorDto errors = new ErrorDto("CONSTRAINTS_VIOLATION_ERROR", e.getMessage());
        return new ResponseEntity<>(List.of(errors), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({UndefinedRepoException.class})
    public ResponseEntity<?> handleInternalServiceError(RuntimeException e) {
        ErrorDto errors = new ErrorDto("INTERNAL_ERROR", e.getMessage());
        return new ResponseEntity<>(List.of(errors), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<List<ErrorDto>> handleAllOtherException(RuntimeException e) {
        log.info("Exception '{}' is handled. Message: '{}'.",
                e.getClass().getName(),
                e.getMessage());
        ErrorDto error = new ErrorDto("INTERNAL_ERROR", e.getMessage());
        return new ResponseEntity<>(List.of(error), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
