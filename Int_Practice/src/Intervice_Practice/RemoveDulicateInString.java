package Intervice_Practice;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDulicateInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name= "joashjanan";
		
		Map<Character,Long> dup= name.chars().mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue()>1)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		
		Map<Character,Long> s=  name.chars().mapToObj(c->(char)c)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println("->>"+s);

		System.out.println(dup);
		
		 List<Character> afterrremove =name.chars().distinct().mapToObj(c -> (char)c)
				.collect(Collectors.toList());
		 
		 System.out.println(afterrremove);
		 
		 String afterrremoves =name.chars().distinct().mapToObj(c ->  String.valueOf((char)c))
					.collect(Collectors.joining());
			 
			 System.out.println(afterrremoves);
			 
			 int num=122445;
			 
			String ss= String.valueOf(num).chars().distinct().mapToObj(c -> String.valueOf((char)c))
			 .collect(Collectors.joining());
			
			System.out.println(ss);
	
	}

}
