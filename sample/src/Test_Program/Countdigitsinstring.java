package Test_Program;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Countdigitsinstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name="joashjanan";
				
				Map<Character,Long> countdigit = name.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	
				System.out.println(countdigit);
				
				Map<Character,Long> countdigits = name.chars().mapToObj(c->(char)c)
						.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
						.entrySet().stream().filter(Entry -> Entry.getValue() >1).collect(Collectors.toMap(Entry::getKey,Entry::getValue));
	System.out.println(countdigits);
	}

}
