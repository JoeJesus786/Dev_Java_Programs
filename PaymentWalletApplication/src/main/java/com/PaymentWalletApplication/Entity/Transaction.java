package com.PaymentWalletApplication.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;
    private double amount;
    private LocalDate date;
    private LocalTime time;

	@ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Transaction(int id, String status, double amount, LocalDate date, LocalTime time, Wallet wallet) {
		super();
		this.id = id;
		this.status = status;
		this.amount = amount;
		this.date = date;
		this.time = time;
		this.wallet = wallet;
	}

	public Transaction() {
		super();
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", status=" + status + ", amount=" + amount + ", date=" + date + ", time="
				+ time + ", wallet=" + wallet + "]";
	}
	
	
	

}
