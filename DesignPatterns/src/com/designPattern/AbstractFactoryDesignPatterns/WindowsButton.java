package com.designPattern.AbstractFactoryDesignPatterns;

public class WindowsButton implements Button{
	
	public void paint()
	{
		System.out.println("Rendering a button in Windows style.");
	}

}
