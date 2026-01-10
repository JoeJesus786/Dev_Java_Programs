package sample;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		   String fullname = "Copilo";
		   		 fullname.chars().mapToObj(c -> (char) c).forEach(System.out::println);
		   		 
		   		 String name="joashjanan";
		   	List<Character>	s= name.chars().distinct().mapToObj(ss -> (char)ss)
		   		 .collect(Collectors.toList());
		   	System.out.println(s);
		   	
		   Map<Character,Long> m =name.chars().mapToObj(ss -> (char)ss)
			   		 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			   		 .entrySet().stream().filter(entry -> entry.getValue()>1)
			   		 .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
			   	System.out.println(m);
			   	
			   	//group dept top 3 slary find using java 
	}
}