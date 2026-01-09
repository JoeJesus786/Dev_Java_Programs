package com.designPattern.PrototypeDesignPatterns;

public class Employee implements Prototype{


private String name;
private String designation;



public Employee(String name, String designation) {
	this.name = name;
	this.designation = designation;
}

public Prototype clone() {
	return new Employee(name, designation);
}

public void showDetails()
{
System.out.println("Name: " + name + ", Designation: " + designation);	
}

}
