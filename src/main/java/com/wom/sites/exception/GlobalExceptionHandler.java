package com.wom.sites.exception;

import com.wom.sites.sitios.Sites;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Sites> handleException(ResourceNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }
}
