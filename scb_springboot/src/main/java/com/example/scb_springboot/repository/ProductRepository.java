package com.example.scb_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scb_springboot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
