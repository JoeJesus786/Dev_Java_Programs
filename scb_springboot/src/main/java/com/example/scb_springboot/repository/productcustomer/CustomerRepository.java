package com.example.scb_springboot.repository.productcustomer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scb_springboot.entity.productcustomer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
