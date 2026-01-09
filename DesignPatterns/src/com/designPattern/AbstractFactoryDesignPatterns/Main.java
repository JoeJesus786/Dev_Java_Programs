package com.designPattern.AbstractFactoryDesignPatterns;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUIFactory factory;
		

String osName = "Windows"; // Change to "Mac" to test MacFactory

if (osName.equals("Windows")) {
factory = new WindowsFactory();
} else {
factory = new MacFactory();
}

Application app = new Application(factory);
app.render();


	}

}
