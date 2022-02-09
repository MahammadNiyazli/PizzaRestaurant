package com.company.exceptionHandling;

import com.company.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = {InvalidArgException.class})
    public ResponseEntity<ResponseDto> handleException( InvalidArgException e) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE , "exception = ", e);
        return ResponseEntity.ok(ResponseDto.of(null,e.getCode(),e.getMessage()));
    }
}
