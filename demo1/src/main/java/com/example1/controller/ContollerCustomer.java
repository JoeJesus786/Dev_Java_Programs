package com.example1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example1.CustomException.EmailNotFoundException;
import com.example1.Entity.EntityCustomer;

@RestController
@RequestMapping
public class ContollerCustomer {
	
	private List<EntityCustomer> customerlist = Arrays.asList(
			new EntityCustomer(1, "joe", "joe@gmail.com"),
			new EntityCustomer(2, "ram", "joe1@gmail.com"),
			new EntityCustomer(3, "mani", "joe2@gmail.com")
			);
	
	@GetMapping("/greed")
	public void Greedmsg()
	{
		System.out.println("Hello, welcome to Spring Boot!");
	}
	@GetMapping("/all")
	public List<EntityCustomer> getalldetails()
	{
		return customerlist;
	}

	@GetMapping("/{id}")
	public EntityCustomer getById(@PathVariable int id)
	{
		return customerlist.stream().filter(c -> c.getId() == id).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"customer not found with id"+id));
	}
	@GetMapping("/gmail/{email}")
	public EntityCustomer getEmailBy(@PathVariable String email)
	{
		return customerlist.stream().filter(s -> s.getEmail() == email).findFirst().orElseThrow(() -> new EmailNotFoundException(email));
	}
}
