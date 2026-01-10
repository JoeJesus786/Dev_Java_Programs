package com.example.scb_springboot.controller.productcustomer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scb_springboot.entity.productcustomer.Customer;
import com.example.scb_springboot.service.productcustomer.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/above-order-value/{value}")
    public List<Customer> getCustomersWithOrdersAbove(@PathVariable Double value) {
        return customerService.getCustomersWithOrdersAbove(value);
    }

    @GetMapping("/partition-by-order-value/{threshold}")
    public Map<Boolean, List<Customer>> partitionCustomersByOrderValue(@PathVariable Double threshold) {
        return customerService.partitionCustomersByOrderValue(threshold);
    }
}
