package sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Simple {
	public static void main(String[] args) {
	
 List<Integer> ar = Arrays.asList(7,2,4,5,6);
	
 List<Integer> sor =ar.stream().limit(3).sorted().toList();
 
 List<Integer> fin = Stream.concat(sor.stream(), ar.stream().skip(3)).collect(Collectors.toList());

System.out.println(fin);
 
	}	
	
}
