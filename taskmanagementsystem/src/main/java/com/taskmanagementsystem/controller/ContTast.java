package com.taskmanagementsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagementsystem.model.Customer;
import com.taskmanagementsystem.model.Task;
import com.taskmanagementsystem.service.TaskService;

@RestController
@RequestMapping()
public class ContTast {

@GetMapping("/greet")
    public String greet() {
        return "Hello, welcome to Spring Boot!";
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return Arrays.asList(
            new Customer(1, "John Doe", "john@example.com"),
            new Customer(2, "Jane Smith", "jane@example.com")
        );
    }


}
