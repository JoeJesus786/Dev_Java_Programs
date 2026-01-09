package com.bank.project.dao;

import java.util.List;

import com.bank.project.bean.Customer;

public interface CustomerDao {
	Customer save(Customer user);
	Customer update(int id, Customer user);
	Customer getById(int id);
	boolean delete(int id);
	List<Customer>getAll();
}
