package com.OneToOneMapping.UserDTO;

public class UserDTO {

	private String name;
	private String street;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public UserDTO(String name, String street) {
		super();
		this.name = name;
		this.street = street;
	}
	public UserDTO() {
		super();
	}
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", street=" + street + "]";
	}
	
	
}
