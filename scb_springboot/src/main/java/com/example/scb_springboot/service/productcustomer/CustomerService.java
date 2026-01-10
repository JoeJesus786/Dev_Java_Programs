package com.example.scb_springboot.service.productcustomer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scb_springboot.entity.productcustomer.Customer;
import com.example.scb_springboot.entity.productcustomer.Order;
import com.example.scb_springboot.repository.productcustomer.CustomerRepository;
import com.example.scb_springboot.repository.productcustomer.OrderRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<Customer> getCustomersWithOrdersAbove(Double value) {
        return customerRepository.findAll().stream()
                .filter(customer -> {
                    double total = orderRepository.findAll().stream()
                            .filter(order -> order.getCustomer().getId().equals(customer.getId()))
                            .mapToDouble(Order::getTotalAmount)
                            .sum();
                    return total > value;
                })
                .collect(Collectors.toList());
    }

    public Map<Boolean, List<Customer>> partitionCustomersByOrderValue(Double threshold) {
        return customerRepository.findAll().stream()
                .collect(Collectors.partitioningBy(customer -> {
                    double total = orderRepository.findAll().stream()
                            .filter(order -> order.getCustomer().getId().equals(customer.getId()))
                            .mapToDouble(Order::getTotalAmount)
                            .sum();
                    return total > threshold;
                }));
    }
}
