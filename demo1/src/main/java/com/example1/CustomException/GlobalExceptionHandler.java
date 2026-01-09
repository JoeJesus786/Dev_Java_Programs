package com.example1.CustomException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.annotation.PostConstruct;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@PostConstruct
    public void init() {
        System.out.println("GlobalExceptionHandler initialized");
    }
	
	@ExceptionHandler(EmailNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleEmailNotFound(EmailNotFoundException ex)
	{
		return new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());
	}
	


}
