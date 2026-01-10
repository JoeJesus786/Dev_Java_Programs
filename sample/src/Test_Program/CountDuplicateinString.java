package Test_Program;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicateinString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name="joashjanan";
		
		Map<Character,Long> dupcount=name.chars().mapToObj(c -> (char)c)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting())					
						
						).entrySet().stream().filter(entry -> entry.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

			System.out.println(dupcount);
	}

}
