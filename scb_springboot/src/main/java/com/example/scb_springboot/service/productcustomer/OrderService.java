package com.example.scb_springboot.service.productcustomer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scb_springboot.entity.productcustomer.Order;
import com.example.scb_springboot.repository.productcustomer.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getCustomer().getId().equals(customerId))
                .collect(Collectors.toList());
    }

    public Double getTotalOrderValueByCustomer(Long customerId) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getCustomer().getId().equals(customerId))
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }
}
