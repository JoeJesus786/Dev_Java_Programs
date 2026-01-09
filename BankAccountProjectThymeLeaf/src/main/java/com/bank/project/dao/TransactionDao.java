package com.bank.project.dao;

import java.util.List;

import com.bank.project.bean.Transaction;

public interface TransactionDao {
	Transaction save(Transaction user);
	Transaction update(int id, Transaction user);
	Transaction getById(int id);
	boolean delete(int id);
	List<Transaction>getAll();
}
