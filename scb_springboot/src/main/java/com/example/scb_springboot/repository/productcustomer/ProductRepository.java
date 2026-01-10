package com.example.scb_springboot.repository.productcustomer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scb_springboot.entity.productcustomer.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {}
