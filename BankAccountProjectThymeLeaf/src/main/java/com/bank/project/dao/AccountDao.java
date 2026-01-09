package com.bank.project.dao;

import java.util.List;

import com.bank.project.bean.Account;

public interface AccountDao {
	Account save(Account user);
	Account update(int id, Account user);
	Account getById(int id);
	boolean delete(int id);
	List<Account>getAll();
	Account getByAccountNumber(String accountNumber);
	Account updateByAccountNumber(String accountNumber, Account account);
}
