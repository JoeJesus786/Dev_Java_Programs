package java_Prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Institute {
	

private String name;
private List<String> locations;



	public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public List<String> getLocations() {
	return locations;
}



public void setLocations(List<String> locations) {
	this.locations = locations;
}



	@Override
public String toString() {
	return "Institute [name=" + name + ", locations=" + locations + "]";
}



	public Institute() {
	super();
}



	public Institute(String name, List<String> locations) {
	super();
	this.name = name;
	this.locations = locations;
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

List<Institute> instituteList = new ArrayList<>();

instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));


//Java 8 Map() : Get names of all institutes
       
List<String> namesOfInstitutes = instituteList.stream().map(Institute::getName).collect(Collectors.toList());
System.out.println(namesOfInstitutes);



//Java 8 FlatMap() : Get unique locations of all institutes
         
Set<String> locationsOfInstitutes = instituteList.stream().flatMap(institute -> institute.getLocations().stream()).collect(Collectors.toSet());
System.out.println(locationsOfInstitutes);

	}

}
