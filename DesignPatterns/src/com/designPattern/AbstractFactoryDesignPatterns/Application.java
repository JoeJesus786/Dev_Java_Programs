package com.designPattern.AbstractFactoryDesignPatterns;

public class Application {
	

private Button button;
private Checkbox checkbox;


public Application(GUIFactory factory) 
{
	button = factory.createButton();
	checkbox = factory.createCheckbox();
}


public void render()
{
	button.paint();
	checkbox.paint();
}

}
