package com.qsp.SpringDemo.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {
	
	@ExceptionHandler(ProductIDNotFound.class)
	public ResponseEntity<Object> entity(ProductIDNotFound p)
	{
		return new ResponseEntity<Object>(p.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
