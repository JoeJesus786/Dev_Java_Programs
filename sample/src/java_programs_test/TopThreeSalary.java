package java_programs_test;

import java.util.Arrays;
import java.util.List;

public class TopThreeSalary {

	int id;
    String name;
    String dept;
    double salary;

	public TopThreeSalary(int id, String name, String dept, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	
	

	@Override
	public String toString() {
		return "TopThreeSalary [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	


List<TopThreeSalary> customers = Arrays.asList(
    new TopThreeSalary(1, "John", "it", 1000),
    new TopThreeSalary(2, "ramu", "hr", 4000),
    new TopThreeSalary(3, "Doe", "it", 3000),
    new TopThreeSalary(4,"rv", "ec", 5000),
    new TopThreeSalary(5, "pm", "it", 9000),
    new TopThreeSalary(6, "cm", "HR", 6000)
);

	}

}
