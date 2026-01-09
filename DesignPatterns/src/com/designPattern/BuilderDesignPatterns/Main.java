package com.designPattern.BuilderDesignPatterns;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


Computer gamingPC = new Computer.ComputerBuilder("1TB", "32GB")
								.setGraphicsCardEnabled(true)
								.setBluetoothEnabled(true)
								.build();

                                

Computer officePC = new Computer.ComputerBuilder("500GB", "8GB")
                                .setBluetoothEnabled(false)
                                .build();

 				System.out.println(gamingPC);
 				System.out.println(officePC);


	}

}
