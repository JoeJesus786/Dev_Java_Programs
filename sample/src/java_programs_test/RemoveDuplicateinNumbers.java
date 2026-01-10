package java_programs_test;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RemoveDuplicateinNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int num=546446;
		
	List<String> redup=	String.valueOf(num).chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.toList());
	
	System.out.println(redup);
		
	}

}
