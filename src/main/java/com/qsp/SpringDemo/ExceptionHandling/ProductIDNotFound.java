package com.qsp.SpringDemo.ExceptionHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class ProductIDNotFound extends Exception{
	
	@Override
	public String getMessage() {
		
		return "Id not found";
	}
	
	

}
