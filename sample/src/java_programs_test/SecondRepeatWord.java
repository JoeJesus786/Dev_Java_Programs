package java_programs_test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondRepeatWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


String name = "I ss love India India love I ss";
        String[] words = name.split(" ");

        Set<String> seen = new HashSet<>();
        List<String> repeating = new ArrayList<>();

        for (String word : words) {
            if (seen.contains(word)) {
            	//System.out.println("inside seen if"+seen);
                if (!repeating.contains(word)) {
                    repeating.add(word);
                    //System.out.println("inside reapeat if"+repeating);
                }
            } else {
                seen.add(word);
                //System.out.println("else seen "+seen); 
            }
        }

        if (repeating.size() >= 2) {
            System.out.println("Second repeating word: " + repeating.get(1));
        } else {
            System.out.println("Less than two repeating words found.");
        }

	}

}
