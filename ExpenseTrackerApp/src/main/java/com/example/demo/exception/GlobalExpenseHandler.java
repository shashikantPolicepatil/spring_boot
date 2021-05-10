package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExpenseHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<CustomException> handleCustomException(CustomException customException) {
		return new ResponseEntity<CustomException>(customException,HttpStatus.BAD_REQUEST);
		
	}
}
