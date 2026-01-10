package com.PaymentWalletApplication.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionResponse {

	private int transactionId;
    private int walletId;
    private String status;
    private double amount;
    private LocalDate date;
    private LocalTime time;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
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
	public TransactionResponse(int transactionId, int walletId, String status, double amount, LocalDate date,
			LocalTime time) {
		super();
		this.transactionId = transactionId;
		this.walletId = walletId;
		this.status = status;
		this.amount = amount;
		this.date = date;
		this.time = time;
	}
	public TransactionResponse() {
		super();
	}
	@Override
	public String toString() {
		return "TransactionResponse [transactionId=" + transactionId + ", walletId=" + walletId + ", status=" + status
				+ ", amount=" + amount + ", date=" + date + ", time=" + time + "]";
	}
    
    
}
