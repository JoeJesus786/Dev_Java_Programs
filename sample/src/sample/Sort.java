package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> num = Arrays.asList(4, 2, 3, 5, 1);
		
		List<Integer> sorts = num.stream().limit(3).sorted().collect(Collectors.toList());
		
		List<Integer> finalsorts = Stream.concat(sorts.stream(), num.stream().skip(3)).collect(Collectors.toList());
		
		System.out.println(finalsorts);
	}

}
