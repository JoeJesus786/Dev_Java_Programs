package com.example.scb_springboot.controller.productcustomer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scb_springboot.entity.productcustomer.Order;
import com.example.scb_springboot.service.productcustomer.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }

    @GetMapping("/total/{customerId}")
    public Double getTotalOrderValueByCustomer(@PathVariable Long customerId) {
        return orderService.getTotalOrderValueByCustomer(customerId);
    }
}
