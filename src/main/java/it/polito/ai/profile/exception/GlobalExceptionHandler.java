package it.polito.ai.profile.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import java.security.SignatureException;
import java.util.NoSuchElementException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(UNAUTHORIZED)
    @ExceptionHandler(FailedToLoginException.class)
    public void failedToLogin() {
    }

    @ResponseStatus(FORBIDDEN)
    @ExceptionHandler(SignatureException.class)
    public void failedToVerify() {
        System.out.println("");
    }
    
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(FailedToSignupException.class)
    public void failedToSignup() {
    }
    
    @ResponseStatus(UNAUTHORIZED)
    @ExceptionHandler(FailedToAuthenticate.class)
    public void failedToAuthenticate() {
    }
    
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void failedToValidate() {
    }
    
    @ResponseStatus(CONFLICT)
    @ExceptionHandler(ProfileCreationConflict.class)
    public void profileConflict() {
    }
    
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public void notFound() {
    }
}
