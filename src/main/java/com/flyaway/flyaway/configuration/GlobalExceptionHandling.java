package com.flyaway.flyaway.configuration;

import com.flyaway.flyaway.domain.exception.AccessDeniedException;
import com.flyaway.flyaway.domain.exception.GenericExceptionResponse;
import com.flyaway.flyaway.domain.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Profile("rest")
@RestControllerAdvice
public class GlobalExceptionHandling {

  @ExceptionHandler
  public ResponseEntity<GenericExceptionResponse> handleGenericException (ResourceNotFoundException exp, HttpServletRequest req){
    var response = new GenericExceptionResponse(HttpStatus.BAD_REQUEST.value(),req.getRequestURI(), exp.getMessage());
    return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler
  public ResponseEntity<GenericExceptionResponse> handleGenericException (AccessDeniedException exp, HttpServletRequest req){
    var response = new GenericExceptionResponse(HttpStatus.BAD_REQUEST.value(),req.getRequestURI(), exp.getMessage());
    return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
  }


}
