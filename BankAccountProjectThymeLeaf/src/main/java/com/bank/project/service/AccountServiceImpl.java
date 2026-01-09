package com.bank.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.project.bean.Account;
import com.bank.project.bean.Transaction;
import com.bank.project.dao.AccountDao;

@Service
public class AccountServiceImpl {

	@Autowired
	private AccountDao accountDao;

	public Account createNewAccount() {
		return accountDao.save(null);
	}

	public Account checkBalance(String accountNumber) {
		return accountDao.getByAccountNumber(accountNumber);
	}

	public Account deposit(String accountNumber, Account account) {
		Account a = accountDao.getByAccountNumber(accountNumber);
		a.setBalance(account.getBalance() + a.getBalance());
		List<Transaction> trans = new ArrayList<>();
		Transaction transaction = new Transaction();
		transaction.setAmount(account.getBalance());
		transaction.setAccount(a);
		transaction.setType("Deposit");
		trans.add(transaction);
		a.setTransactions(trans);
		return accountDao.save(a);

	}
	public Account withdraw(String accountNumber, Account account) {
		Account a = accountDao.getByAccountNumber(accountNumber);
		System.out.println(a.getBalance());
		if(a.getBalance() - account.getBalance() <0)
		{
		throw new IllegalArgumentException("insufficient balance");
		}
			a.setBalance(a.getBalance() - account.getBalance());
			List<Transaction> trans = new ArrayList<>();
			Transaction transaction = new Transaction();
			transaction.setAmount(account.getBalance());
			transaction.setAccount(a);
			transaction.setType("Withdraw");
			trans.add(transaction);
			a.setTransactions(trans);
			return accountDao.save(a);
		
		
	
	    

	}

}
