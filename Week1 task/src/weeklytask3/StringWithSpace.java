package weeklytask3;

import java.util.function.Function;

public class StringWithSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Function<String, String> formatter = str -> String.join(" ", str.split(""));
		System.out.println(formatter.apply("joashjanan"));

	}

}
