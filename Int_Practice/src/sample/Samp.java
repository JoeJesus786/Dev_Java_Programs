package sample;

import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Samp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> name = Arrays.asList("j,o,a,s,h,j,a,n,a,n".split(","));
		
	List<String> nam=	name.stream().distinct().filter(s->s.length()>=1).collect(Collectors.toList());
	
	System.out.println(nam);
	
	int a=123;

	//count
	long count =String.valueOf(a).chars().map(c->c -'0').count();
	System.out.println(count);
	//sum
	int sum =String.valueOf(a).chars().map(c->c -'0').sum();
	System.out.println(sum);
	
	// remove duplicate
	String names ="joashjanan";
	
	List<String> nams= Arrays.asList("j,o,a,s,h,j,a,n,a,n".split(","));
	
	List<String> afterremove= nams.stream().distinct().filter(s->s.length()>=1).collect(Collectors.toList());
	System.out.println(afterremove);
	//remove vowel
	
	Map<Character, Long> noofvowels=names.chars().mapToObj(c->(char)c).filter(ch->"aeiouAEIOU".indexOf(ch) != -1)
	.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	
	System.out.println(noofvowels);
	// count j
	
	Map<Character, Long> noofj=names.chars().mapToObj(cc->(char)cc).filter(chh->"j".indexOf(chh) != -1)
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	System.out.println(noofj);
	//display unique
	
	Map<Character,Long> uniqueword=names.chars().mapToObj(t->(char)t).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
	.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	
	System.out.println(uniqueword);
	
	//place all j to left side
	
	

	}

}
