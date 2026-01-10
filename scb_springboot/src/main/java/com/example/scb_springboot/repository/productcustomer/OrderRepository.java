package com.example.scb_springboot.repository.productcustomer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scb_springboot.entity.productcustomer.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{}