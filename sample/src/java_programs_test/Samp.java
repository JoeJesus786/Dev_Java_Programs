package java_programs_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Samp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=123;
		String name ="joashjanan";
		
		// unique list
		List<String> names =Arrays.asList("j,o,a,s,h,j,a,n,a,n".split(","));
		
		List<String> uniq = names.stream().distinct().collect(Collectors.toList());
		System.out.println("using list"+uniq);
		
		//remove dupilcate
		
		Map<Character,Long>	duplicate =name.chars().distinct().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(duplicate);
		List<Character>	duplicate1 =name.chars().distinct().mapToObj(c->(char)c).collect(Collectors.toList());
		System.out.println(duplicate1);
		
		
		//display vowels 
		List<Character> vowelsinname =name.chars().mapToObj(c->(char)c).filter(ch->"aeiouAEIOU".indexOf(ch) >=0).collect(Collectors.toList());
		System.out.println(vowelsinname);
		
		// count
		
	long con=	String.valueOf(num).chars().map(g->g - '0').count();
	System.out.println(con);
	
	int summ=String.valueOf(num).chars().map(gh->gh - '0').sum();
	System.out.println(summ);
		// sum
	
	List<String> jleft =names.stream().filter(fg->"j".indexOf(fg)>=0).collect(Collectors.toList());
	List<String> jleftnot =names.stream().filter(fgg->!("j".indexOf(fgg)>=0)).collect(Collectors.toList());
	System.out.println(jleft);
	System.out.println(jleftnot);
	
	List<String> addtwo = new ArrayList<String>();
	
	addtwo.addAll(jleft);
	addtwo.addAll(jleftnot);
	System.out.println(addtwo);
	
	List<String> conlist= Stream.concat(names.stream().filter(fg->"j".indexOf(fg)>=0), names.stream().filter(fgg->!("j".indexOf(fgg)>=0)))
	.collect(Collectors.toList());
	System.out.println("concat"+conlist);
	
//filter map using entery set	
	
Map<Character,Long> entrysetfileter=name.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
	.entrySet().stream().filter(y->y.getValue()>1).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
System.out.println(entrysetfileter);


}
}

