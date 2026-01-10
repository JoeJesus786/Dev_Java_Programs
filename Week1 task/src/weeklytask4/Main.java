package weeklytask4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeService service = new EmployeeService();
		

System.out.println("Total Salary: " + service.getTotalSalary());

        System.out.println("\nDepartment Employee Counts:");
        service.getDepartmentEmployeeCounts().forEach((dept, count) ->
            System.out.println(dept + ": " + count));

        System.out.println("\nSenior Most Employee:");
        service.getSeniorMostEmployee().ifPresent(e ->
            System.out.println(e.getfullName() + " - " + e.getHireDate()));

        System.out.println("\nEmployee Service Durations:");
        service.getEmployeeServiceDuration().forEach((name, duration) ->
            System.out.println(name + ": " + duration));

System.out.println("\nEmployees Without Department:");
        service.getEmployeesWithoutDepartment().forEach(e ->
            System.out.println(e.getfullName()));

System.out.println("\nDepartments Without Employees:");
service.getDepartmentsWithoutEmployees().forEach(d -> System.out.println(d.getDepartmentName()));

System.out.println("\nDepartments With Highest Employee Count:");
service.getDepartmentsWithHighestEmployeeCount().forEach(System.out::println);

System.out.println("\nEmployee Hire Day Info:");
service.getEmployeeHireDayInfo().forEach((name, info) -> System.out.println(name + ": " + info));

System.out.println("\nEmployees Hired on FRIDAY:");
service.getEmployeesHiredOnDay("FRIDAY").forEach(e -> System.out.println(e.getfullName()));


System.out.println("\nEmployee-Manager Report:");
service.getEmployeeManagerReport().forEach(System.out::println);

System.out.println("\nSalary with 15% Increment:");
service.getSalaryWithIncrement().forEach((name, salary) -> System.out.println(name + ": " + salary));

System.out.println("\nEmployees Without Manager:");
service.getEmployeesWithoutManager().forEach(e -> System.out.println(e.getfullName()));


	}

}
