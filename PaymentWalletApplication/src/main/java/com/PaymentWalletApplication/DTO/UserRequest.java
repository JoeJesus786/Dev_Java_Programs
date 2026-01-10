package com.PaymentWalletApplication.DTO;

public class UserRequest {
	private String username;
    private String password;
    private String emailId;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public UserRequest(String username, String password, String emailId) {
		super();
		this.username = username;
		this.password = password;
		this.emailId = emailId;
	}
	public UserRequest() {
		super();
	}
	@Override
	public String toString() {
		return "UserRequest [username=" + username + ", password=" + password + ", emailId=" + emailId + "]";
	}
    
    
}
