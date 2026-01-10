package com.PaymentWalletApplication.ExceptionHandler;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.annotation.PostConstruct;

@RestControllerAdvice
public class GlobalExceptionHandler {
	

    @PostConstruct
    public void init() {
        System.out.println("GlobalExceptionHandler initialized");
    }

	@ExceptionHandler(InsufficientBalanceException.class)
	@ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
    public ErrorResponse handleInsufficientBalance(InsufficientBalanceException ex) {

        return new ErrorResponse(LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),ex.getMessage());
    }

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleUserNotFound(UserNotFoundException ex)
	{
		return new ErrorResponse(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());
	}
	
	@ExceptionHandler(WalletNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleWalletNotFound(WalletNotFoundException ex)
	{
		return new ErrorResponse(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());
	}

}
