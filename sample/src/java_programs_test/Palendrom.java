package java_programs_test;

public class Palendrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "madam";
		
		boolean isPalindrome = true;
		
		for(int i=0;i<name.length()/2;i++)			
		{
			System.out.println(name.length()/2);
			
			System.out.println(name.charAt(i));
			
			System.out.println(name.length()-i-1);
			
			System.out.println(name.charAt(i) != name.charAt(name.length()-i-1));
			if(name.charAt(i) != name.charAt(name.length()-i-1))
			{				
				isPalindrome = false;
			}
		}

		System.out.println(isPalindrome?"palindrome" :"not palindrome");
	}

}
