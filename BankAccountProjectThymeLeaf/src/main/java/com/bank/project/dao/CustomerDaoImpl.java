package com.bank.project.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.project.bean.Customer;
import com.bank.project.database.DBUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Component
public class CustomerDaoImpl implements CustomerDao{

	private static EntityManager manager;

	public CustomerDaoImpl() 
	{
		manager = DBUtil.getManager();
	}

	public void beginTransaction() 
	{
		manager.getTransaction().begin();		
	}
	public void commitTransaction() 
	{
		manager.getTransaction().commit();		
	}
	@Override
	public Customer save(Customer customer) 
	{
		beginTransaction();
		manager.persist(customer);
		commitTransaction();
		System.out.println(customer+" saved");
		return customer;
	}

	@Override
	public Customer getById(int id)
	{
		beginTransaction();
		Customer e =manager.find(Customer.class, id);
		commitTransaction();
		return e;
	}

	@Override
	public Customer update(int id, Customer user) 
	{

		beginTransaction();
		Customer e =manager.find(Customer.class, id);
//		e.setName(user.getName());
//		e.setEmail(user.getProfession());
		///so one
		manager.persist(e);
		commitTransaction();
		return e;
	}

	@Override
	public boolean delete(int id) 
	{
		beginTransaction();
		Customer e =manager.find(Customer.class, id);
		manager.remove(e);
		commitTransaction();

		e =manager.find(Customer.class, id);
		if(e == null)
			return true;
		return false;
	}

	@Override
	public List<Customer> getAll() {
		String jpql = "SELECT e FROM Customer e";
		TypedQuery<Customer> query = manager.createQuery(jpql, Customer.class);
		return query.getResultList();
	}

}
