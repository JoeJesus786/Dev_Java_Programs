package java_programs_test;

public class CleaningString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "joas% !    h";
		
		String cleaned = name.replaceAll("[^a-zA-Z]", "");
		System.out.println(cleaned);
	}

}
