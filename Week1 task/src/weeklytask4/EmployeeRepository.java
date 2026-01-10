package weeklytask4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeeRepository {
	
	public static List<Department> getDepartments()
	{
		return Arrays.asList(
				new Department(1, "HR", 101),
				new Department(2, null, null),
				new Department(3, "Finance", 103),
				new Department(4, "Marketing", null)
				);
	}
	
	public static List<Employee> getEmployees()
	{
		List<Department> departments = getDepartments();
		
		return Arrays.asList(
			new Employee(101, "Alice", "Smith", "alice@example.com", "1234567890", LocalDate.of(2010, 1, 10), "Manager", 90000, null, departments.get(0)),
            new Employee(102, "Bob", "Johnson", "bob@example.com", "1234567891", LocalDate.of(2012, 3, 15), "Developer", 80000, 101, departments.get(1)),
            new Employee(103, "Charlie", "Williams", "charlie@example.com", "1234567892", LocalDate.of(2015, 5, 20), "Analyst", 70000, 101, departments.get(2)),
            new Employee(104, "Diana", "Brown", "diana@example.com", "1234567893", LocalDate.of(2018, 7, 25), "Executive", 60000, 102, null),
            new Employee(105, "Ethan", "Davis", "ethan@example.com", "1234567894", LocalDate.of(2020, 9, 30), "Intern", 40000, 102, departments.get(1))
				);
	}
	

}
