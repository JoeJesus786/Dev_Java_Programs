package com.example1.CustomException;

public class EmailNotFoundException extends RuntimeException{
	
	public EmailNotFoundException(String email)
	{
		super("email not fount"+email);
	}

}
