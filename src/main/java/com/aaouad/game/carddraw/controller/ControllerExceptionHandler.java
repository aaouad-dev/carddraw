package com.aaouad.game.carddraw.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    private ResponseEntity<ErrorResponse> handleGenericException(Exception exception, HttpStatus httpStatus) {
        var errorResponse = new ErrorResponse(exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    static class ErrorResponse{
        private String message;
        private LocalDateTime timestamp;
    }

}
