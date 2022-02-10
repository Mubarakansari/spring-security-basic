package com.springsecurity.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e) {
        log.error("Not Found Exception at {} : {}  on Method: {} : message", e.getStackTrace()[0].getFileName(), e.getStackTrace()[0].getLineNumber(), e.getStackTrace()[0].getMethodName(), e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
