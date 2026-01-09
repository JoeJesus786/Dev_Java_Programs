package com.designPattern.PrototypeDesignPatterns;

public class MainPrototypePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


Employee original = new Employee("Alice", "Developer");
Employee copy = (Employee) original.clone();

original.showDetails();
copy.showDetails();

	}

}
