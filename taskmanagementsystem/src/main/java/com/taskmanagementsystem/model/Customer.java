package com.taskmanagementsystem.model;

public class Customer {
	private Integer customerid;
	private String customername;
	private String email;
	public Customer(Integer customerid, String customername, String email) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.email = email;
	}
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
