package com.spot.task.exception;

import com.spot.task.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleExceptions(CardNotFoundException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setLocalDateTime(LocalDateTime.now());
        response.setMessage("Card not found | card no is invalid");
        ResponseEntity<ExceptionResponse> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(InvalidCarddetailException.class)
    public ResponseEntity<ExceptionResponse> invalidCardDetails(InvalidCarddetailException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setLocalDateTime(LocalDateTime.now());
        response.setMessage(exception.getMessage());
        ResponseEntity<ExceptionResponse> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return entity;
    }

    @ExceptionHandler(DuplicateCard.class)
    public ResponseEntity<ExceptionResponse> duplicateCard(DuplicateCard exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setLocalDateTime(LocalDateTime.now());
        response.setMessage(exception.getMessage());
        ResponseEntity<ExceptionResponse> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return entity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleExceptions(Exception exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setLocalDateTime(LocalDateTime.now());
        response.setMessage(exception.getMessage());
        ResponseEntity<ExceptionResponse> entity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

}
