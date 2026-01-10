package java_Prac;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExp {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

List<String> names = Arrays.asList("john", "jane", "jack");

List<String> upperNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());

//names.stream()..map(String::toUpperCase).collect(Collectors.toList());

System.out.println(upperNames); // Output: [JOHN, JANE, JACK]

List<String> sentences = Arrays.asList("hello world", "java streams", "flat map");

List<String> words = sentences.stream()
                              .map(sentence -> sentence.split(" ")) // Stream<String[]>
                              .flatMap(Arrays::stream)             // Stream<String>
                              .collect(Collectors.toList());

System.out.println(words); // Output: [hello, world, java, streams, flat, map]

//List<String> sentences = Arrays.asList("Hello World", "Java Stream", "flatMap vs map");

//Using map()
List<String> mapped = sentences.stream()
 .map(String::toUpperCase)
 .collect(Collectors.toList());

//Using flatMap()
List<String> flatMapped = sentences.stream()
 .flatMap(s -> Arrays.stream(s.split(" ")))
 .collect(Collectors.toList());

System.out.println("Mapped Size: " + mapped.size());       // Output: 3 (List of arrays)
System.out.println("FlatMapped Size: " + flatMapped.size()); // Output: 6 (All words)

System.out.println("Mapped Size: " + mapped);       // Output: 3 (List of arrays)
System.out.println("FlatMapped Size: " + flatMapped); // Output: 6 (All words)



	}

}
