package java_programs_test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortfirstThreeNUm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> num = Arrays.asList(4,3,1,2,5);
		
		List<Integer> s = num.stream().limit(3).sorted().collect(Collectors.toList());
		
		List<Integer> sortresult = Stream.concat(s.stream(), num.stream().skip(3)).collect(Collectors.toList());
		
		System.out.println(sortresult);

	}

}
