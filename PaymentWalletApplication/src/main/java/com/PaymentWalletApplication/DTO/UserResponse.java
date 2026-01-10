package com.PaymentWalletApplication.DTO;

public class UserResponse {
	
	private int userId;
    private String username;
    private String emailId;
    private String message;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserResponse(int userId, String username, String emailId, String message) {
		super();
		this.userId = userId;
		this.username = username;
		this.emailId = emailId;
		this.message = message;
	}
	public UserResponse() {
		super();
	}
	@Override
	public String toString() {
		return "UserResponse [userId=" + userId + ", username=" + username + ", emailId=" + emailId + ", message="
				+ message + "]";
	}
    
    

}
