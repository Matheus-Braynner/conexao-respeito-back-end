package br.com.grupoconexao.msbff.msbff.controllers.handler;

import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<StandardError> handleFeignException(FeignException e, HttpServletRequest request) {
        String error = "Feign error";
        HttpStatus status = HttpStatus.valueOf(e.status());
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
