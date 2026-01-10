package sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\\
		
		String name = "joashjanan";
		//remove duplicate and list that
		// show and count the duplicate 
		// sort for 3 digit
		//show and count the vowels
		//list the vowels
		
		//sum of digits int =535;
		
		Map<Character,Long> cout =  name.chars().mapToObj(c->(char)c)
		                          .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(cout);
		Map<Character, Long> cout1 =  name.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() >1)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
                
                
 
		System.out.println("Entery set -> "+cout1);
		
		List nam = name.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.toList());
		String nam1 = name.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
		System.out.println(nam);
		System.out.println(nam1);
		
		
		List<Integer> num = Arrays.asList(7,4,2,1,8);
		
		List<Integer> sortnum = num.stream().limit(3).sorted().collect(Collectors.toList());
		 
		List<Integer> finalnum = Stream.concat(sortnum.stream(), num.stream().skip(3)).collect(Collectors.toList());
		
		System.out.println(finalnum);
		
		
		Map<Character, Long> vow =name.chars().mapToObj(c->(char)c)
				.filter(r->"aeiouAEIOU".indexOf(r) != -1)
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		

		
		System.out.println(vow);
		
		
		int n=1234;
		
		int nu= String.valueOf(n).chars().map(c -> c - '0').sum();	
		long nu1= String.valueOf(n).chars().map(c -> c - '0').count();	
		System.out.println("sum of given int -> "+nu);
		System.out.println("count of given int -> "+nu1);
		
		
	}

}
