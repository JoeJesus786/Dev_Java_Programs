package sample;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "joashjanan";
		
		Map<Character, Long> s =name.chars().mapToObj(c ->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

		System.out.println(s);
	}

}
