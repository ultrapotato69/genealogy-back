package com.example.genealogyback.controller_advice;

import com.example.genealogyback.dto.ErrorDto;
import com.example.genealogyback.exception.NoSuchResourceException;
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


    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<List<ErrorDto>> handleAllOtherException(RuntimeException e) {
        log.info("Exception '{}' is handled. Message: '{}'.",
                e.getClass().getName(),
                e.getMessage());
        ErrorDto error = new ErrorDto("INTERNAL_ERROR", e.getMessage());
        return new ResponseEntity<>(List.of(error), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
