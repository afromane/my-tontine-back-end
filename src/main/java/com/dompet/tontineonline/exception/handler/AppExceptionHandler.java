package com.dompet.tontineonline.exception.handler;

import com.dompet.tontineonline.exception.EntityAlreadyExistsException;
import com.dompet.tontineonline.exception.EntityNotFoundException;
import com.dompet.tontineonline.exception.message.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException exception){
        ErrorMessage errorMessage =  ErrorMessage.builder()
                .message(exception.getMessage())
                .code(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public ResponseEntity<Object> entityAlreadyExistsException(EntityAlreadyExistsException exception){
        ErrorMessage errorMessage =  ErrorMessage.builder()
                .message(exception.getMessage())
                .code(409)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }
}
