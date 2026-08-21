package com.substring.auth.app.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

	private String message;
	
}
