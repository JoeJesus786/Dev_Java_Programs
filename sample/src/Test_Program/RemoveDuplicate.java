package Test_Program;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num= 2344446;
		
		List<String> remvariable = String.valueOf(num).chars().distinct().mapToObj(c -> String.valueOf((char)c))
				.collect(Collectors.toList());
	
	System.out.println(remvariable);
	
	String name="joashjanan";
	System.out.println("given name  : "+name);
	Map<Character,Long> duplicatewithcount =name.chars().mapToObj(c->(char)c)
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			.entrySet().stream().filter(entry -> entry.getValue()>1)
			.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	
	System.out.println(duplicatewithcount);

	String afterremove= name.chars().mapToObj(c-> String.valueOf((char)c)).filter(entry -> "aeiouAEIOU".indexOf(entry) != -1)
			.collect(Collectors.joining());
	
	

		
	System.out.println(afterremove);

	}

}
