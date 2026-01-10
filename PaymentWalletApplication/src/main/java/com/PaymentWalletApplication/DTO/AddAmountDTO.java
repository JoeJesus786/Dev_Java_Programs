package com.PaymentWalletApplication.DTO;

public class AddAmountDTO {

	private String emailId;
    private double amount;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public AddAmountDTO(String emailId, double amount) {
		super();
		this.emailId = emailId;
		this.amount = amount;
	}
	public AddAmountDTO() {
		super();
	}
	@Override
	public String toString() {
		return "AddAmountDTO [emailId=" + emailId + ", amount=" + amount + "]";
	}
    
    
    
    
}
