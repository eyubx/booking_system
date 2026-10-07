package com.eyubx.bookingsystem.exception;

import com.eyubx.bookingsystem.api.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    public ResponseEntity<ErrorResponseDTO> handleApp(AppException ex) {
        return ResponseEntity.status(ex.getStatus()).body(
            new ErrorResponseDTO(
                ex.getStatus().value(),
                ex.getMessage(),
                LocalDateTime.now()
            )
        );
    }
}
