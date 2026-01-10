package InterviewTasks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountStringUsingMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name ="joashjanan";
	Map<Character, Long> s=	name.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	System.out.println(s);
	
	//remove duplicate
	int num=653422;
	
	List<String> rem = String.valueOf(num).chars().distinct().mapToObj(c->(String.valueOf((char)c))).collect(Collectors.toList());
	System.out.println("after dupicate are removed"+rem+"from"+num);
	
	Map<Character,Long> d=name.chars().mapToObj(c->(char)c)
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
	.entrySet().stream().filter(entry-> entry.getValue()>1)
	.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	System.out.println(d);
	
	//vovels
	Map<Character, Long> m =name.chars().mapToObj(c->(char)c).filter(r->"aeiouAEIOU".indexOf(r) != -1)
	.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	System.out.println(m);
	

	
	
	int[] num1 = {8,6,2,6,1};
	List<Integer> li = Arrays.asList(8,4,7,1,3);
	//sort first 3
	List<Integer> sr = li.stream().limit(3).sorted().collect(Collectors.toList());
	List<Integer> sk = Stream.concat(sr.stream(), li.stream().skip(3)).collect(Collectors.toList());
	System.out.println(sk);
	
	//count, sum remove duplicate
		int nums=65342;
		int tt =String.valueOf(nums).chars().map(c->c-'0').sum();
		Long vv= String.valueOf(nums).chars().map(c->c-'0').count();
		System.out.println(tt);
		System.out.println(vv);
	
	}
	
   
	
	
	
	

}
