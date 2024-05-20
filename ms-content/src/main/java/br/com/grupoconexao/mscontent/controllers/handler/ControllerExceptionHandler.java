package br.com.grupoconexao.mscontent.controllers.handler;

import br.com.grupoconexao.mscontent.services.exceptions.CannotAttachFileWithDifferentRegistrationException;
import br.com.grupoconexao.mscontent.services.exceptions.ResourceNotFoundException;
import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Objects;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        String error = "Validation error";
        String message = Objects.requireNonNull(e.getFieldError()).getDefaultMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationError err = new ValidationError(Instant.now(), status.value(), error, message,
                request.getRequestURI());
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        String error = "check the fields!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "resource not found!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(CannotAttachFileWithDifferentRegistrationException.class)
    public ResponseEntity<StandardError> CannotAttachFileWithDifferentRegistrationException(CannotAttachFileWithDifferentRegistrationException e, HttpServletRequest request) {
        String error = "check your registration";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<StandardError> handleFeignException(FeignException e, HttpServletRequest request) {
        String error = "Feign error";
        HttpStatus status = HttpStatus.valueOf(e.status());
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
