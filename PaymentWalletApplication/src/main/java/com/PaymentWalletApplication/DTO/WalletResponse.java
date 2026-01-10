package com.PaymentWalletApplication.DTO;

public class WalletResponse {

	private int walletId;
    private int userId;
    private String currency;
    private double balance;
	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public WalletResponse(int walletId, int userId, String currency, double balance) {
		super();
		this.walletId = walletId;
		this.userId = userId;
		this.currency = currency;
		this.balance = balance;
	}
	public WalletResponse() {
		super();
	}
	@Override
	public String toString() {
		return "WalletResponse [walletId=" + walletId + ", userId=" + userId + ", currency=" + currency + ", balance="
				+ balance + "]";
	}
    
    
}
