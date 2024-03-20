package com.project.cybershield.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<ErrorMessage> handlePasswordMismatchException(PasswordMismatchException ex) {
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .error(ex.getLocalizedMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(SecurityAnswerMismatchException.class)
    public ResponseEntity<ErrorMessage> handleSecurityAnswerMismatch(SecurityAnswerMismatchException ex) {
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .error(ex.getLocalizedMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorMessage body = ErrorMessage
                .builder()
                .status(ex.getStatusCode())
                .error(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build();
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorMessage> handleUniqueConstraintViolation(DataIntegrityViolationException ex) {
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .error(ex.getLocalizedMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .error(ex.getLocalizedMessage())
                .status(HttpStatus.CONFLICT)
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleVehicleNotFoundException(EntityNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .error(ex.getLocalizedMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception ex) {
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .error(ex.getLocalizedMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
