package com.PaymentWalletApplication.DTO;

public class TransferDTO {

	private Integer fromWalletId;
    private Integer toWalletId;
    private double amount;
	public Integer getFromWalletId() {
		return fromWalletId;
	}
	public void setFromWalletId(Integer fromWalletId) {
		this.fromWalletId = fromWalletId;
	}
	public Integer getToWalletId() {
		return toWalletId;
	}
	public void setToWalletId(Integer toWalletId) {
		this.toWalletId = toWalletId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransferDTO(Integer fromWalletId, Integer toWalletId, double amount) {
		super();
		this.fromWalletId = fromWalletId;
		this.toWalletId = toWalletId;
		this.amount = amount;
	}
	public TransferDTO() {
		super();
	}
	@Override
	public String toString() {
		return "TransferDTO [fromWalletId=" + fromWalletId + ", toWalletId=" + toWalletId + ", amount=" + amount + "]";
	}
	
    
    
    
}
