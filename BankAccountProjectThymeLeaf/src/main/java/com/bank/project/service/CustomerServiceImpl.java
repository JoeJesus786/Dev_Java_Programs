package com.bank.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.project.bean.Customer;
import com.bank.project.dao.CustomerDao;
@Component
public class CustomerServiceImpl {
	@Autowired
	private CustomerDao customerDao;

	public Customer createNewCustomer(Customer customer) {
		return customerDao.save(customer);
	}
	
	
}
