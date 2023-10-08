package com.goalteller.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundExceptionHandler(ResourceNotFoundException rnfe){
		
		MyErrorDetails er = new MyErrorDetails(LocalDateTime.now(),rnfe.getMessage(),false);
		
		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException me){
		
		MyErrorDetails er = new MyErrorDetails(LocalDateTime.now(),me.getBindingResult().getFieldError().getDefaultMessage(),false);
		
		return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
		
	}

}
