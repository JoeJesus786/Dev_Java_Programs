package com.PaymentWalletApplication.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Wallet {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double balance;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Wallet(int id, double balance, User user, Currency currency, List<Transaction> transactions) {
		super();
		this.id = id;
		this.balance = balance;
		this.user = user;
		this.currency = currency;
		this.transactions = transactions;
	}

	public Wallet() {
		super();
	}

	@Override
	public String toString() {
		return "Wallet [id=" + id + ", balance=" + balance + ", user=" + user + ", currency=" + currency
				+ ", transactions=" + transactions + "]";
	}
    
    
    
    

}
