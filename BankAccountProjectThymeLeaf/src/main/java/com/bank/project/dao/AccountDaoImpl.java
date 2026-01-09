package com.bank.project.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.project.bean.Account;
import com.bank.project.database.DBUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
public class AccountDaoImpl implements AccountDao
{
	private static EntityManager manager;

	public AccountDaoImpl() 
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
	public Account save(Account account) 
	{
		beginTransaction();
		manager.persist(account);
		commitTransaction();
		System.out.println(account+" saved");
		return account;
	}

	@Override
	public Account getById(int id)
	{
		beginTransaction();
		Account e =manager.find(Account.class, id);
		commitTransaction();
		return e;
	}

	@Override
	public Account update(int id, Account user) 
	{

		beginTransaction();
		Account e =manager.find(Account.class, id);
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
		Account e =manager.find(Account.class, id);
		manager.remove(e);
		commitTransaction();

		e =manager.find(Account.class, id);
		if(e == null)
			return true;
		return false;
	}

	@Override
	public List<Account> getAll() {
		String jpql = "SELECT e FROM Account e";
		TypedQuery<Account> query = manager.createQuery(jpql, Account.class);
		return query.getResultList();
	}
	@Override
	public Account getByAccountNumber(String no) {
		System.out.println(no);
		String jpql = "SELECT e FROM Account e where e.accountNumber = ?1";
		TypedQuery<Account> query = manager.createQuery(jpql, Account.class);
		query.setParameter(1, no);
		return query.getSingleResult();
	}

	@Override
	public Account updateByAccountNumber(String accountNumber, Account account) {
		beginTransaction();
		manager.persist(account);
		commitTransaction();
		return account;
	}

}
