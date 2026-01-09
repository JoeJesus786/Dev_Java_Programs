package com.designPattern.AbstractFactoryDesignPatterns;

public class WindowsCheckbox implements Checkbox{
	
	public void paint()
	{
		System.out.println("Rendering a checkbox in Windows style.");
	}

}
