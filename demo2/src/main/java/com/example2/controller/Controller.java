package com.example2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example2.Entity.Employee;

@RestController
@RequestMapping
public class Controller {

	@GetMapping("/hello")
	public String sayhello() {
		return "Hello, Spring Boot!";
	}
	
	@GetMapping("/employee")
	public List<Employee> getallemp()
	{
		return Arrays.asList(
				new Employee(1, "John Doe", "Engineering", "75000"),
				new Employee(2, "John Doe", "Engineering", "75000")
				
				);
	}
}
