package Test_Program;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sortfirstthreedigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> num= Arrays.asList(4,3,1,5,2);
		
		List<Integer> sortedlist =num.stream().limit(3).sorted().collect(Collectors.toList());
		
		List<Integer> finalresult = Stream.concat(sortedlist.stream(), num.stream().skip(3)).collect(Collectors.toList());
		
		System.out.println(finalresult);
		
		List<Integer> number = Arrays.asList(7,2,4,6,5);
		
		List<Integer> sortn= number.stream().limit(3).sorted().collect(Collectors.toList());
		
		List<Integer> aftersort = Stream.concat(sortn.stream(), number.stream().skip(3)).collect(Collectors.toList());
		
		System.out.println("->>"+aftersort);

	}

}
