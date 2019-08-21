package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	//add an exception handler for customerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc)
	{
		//create CustomerErrorRespons
		CustomerErrorResponse error=new CustomerErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		
		//return response  entity
		return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.NOT_FOUND);
		
	}
	//add general exception handler(any exception)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc)
	{
		//create CustomerErrorRespons
		CustomerErrorResponse error=new CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		
		//return response  entity
		return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
}
