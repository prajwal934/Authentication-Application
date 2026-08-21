package com.substring.auth.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.substring.auth.app.utility.ErrorStructure;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

	private ErrorStructure<String> errorStructure;
	
	private ResponseEntity<ErrorStructure<String>> errorResonse(HttpStatus status, String message, String rootCause){
		return new ResponseEntity<ErrorStructure<String>>(errorStructure.setStatusCode(status.value())
				.setMessage(message)
				.setRootCause(rootCause),status);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleResourceNotFoundException(ResourceNotFoundException ex){
		return errorResonse(HttpStatus.NOT_FOUND, ex.getMessage(), "User isn't found with given email id!!");
	}
}
