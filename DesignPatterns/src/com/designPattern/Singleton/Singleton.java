package com.designPattern.Singleton;

public class Singleton {
	
	// Static variable to hold the single instance
    private static Singleton singleInstance;

    // Private constructor to prevent instantiation
    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    // Public method to provide access to the instance
    public static Singleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }
        return singleInstance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub


		// Get the only object available
Singleton obj1 = Singleton.getInstance();
obj1.showMessage();

// Try to get another instance
Singleton obj2 = Singleton.getInstance();
obj2.showMessage();

// Check if both references point to the same object
System.out.println("Are both instances the same? " + (obj1 == obj2));

	}


}
