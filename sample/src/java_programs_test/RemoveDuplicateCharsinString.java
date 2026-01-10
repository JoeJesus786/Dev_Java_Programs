package java_programs_test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicateCharsinString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="joashjanan";
		
		String removedup =name.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
		System.out.println(removedup);
		
		
	
	
	}

}
