package sample;

public class Sample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 10; // Integer (4 bytes)
		double data = num; // Automatically converted to double (8 bytes)
		System.out.println("Integer value: " + num);
		System.out.println("Double value: " + data);
		
		double num1 = 10.99; // Double (8 bytes)
		int data1 =  num; // Manually cast to integer (4 bytes)
		System.out.println("Double value: " + num1);
		System.out.println("Integer value: " + data1);
		}


}
