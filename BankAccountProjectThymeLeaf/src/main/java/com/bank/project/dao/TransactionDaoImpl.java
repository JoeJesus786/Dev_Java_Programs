package com.bank.project.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.project.bean.Transaction;
import com.bank.project.database.DBUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Component
public class TransactionDaoImpl implements TransactionDao{

	private static EntityManager manager;

	public TransactionDaoImpl() 
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
	public Transaction save(Transaction transaction) 
	{
		beginTransaction();
		manager.persist(transaction);
		commitTransaction();
		System.out.println(transaction+" saved");
		return transaction;
	}

	@Override
	public Transaction getById(int id)
	{
		beginTransaction();
		Transaction e =manager.find(Transaction.class, id);
		commitTransaction();
		return e;
	}

	@Override
	public Transaction update(int id, Transaction user) 
	{

		beginTransaction();
		Transaction e =manager.find(Transaction.class, id);
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
		Transaction e =manager.find(Transaction.class, id);
		manager.remove(e);
		commitTransaction();

		e =manager.find(Transaction.class, id);
		if(e == null)
			return true;
		return false;
	}

	@Override
	public List<Transaction> getAll() {
		String jpql = "SELECT e FROM Transaction e";
		TypedQuery<Transaction> query = manager.createQuery(jpql, Transaction.class);
		return query.getResultList();
	}


}
