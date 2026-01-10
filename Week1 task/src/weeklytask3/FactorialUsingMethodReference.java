package weeklytask3;

interface FactorialFunction{
	int compute(int n);
}
public class FactorialUsingMethodReference {
	
	public static int factorial(int n)
	{
		return (n == 0) ? 1 : n * factorial(n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorialFunction fact = FactorialUsingMethodReference::factorial;
		System.out.println("Factorial of 5: " + fact.compute(5));

	}

}
