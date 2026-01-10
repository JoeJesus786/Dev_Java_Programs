package weeklytask4;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeService {
	private List<Employee> employees = EmployeeRepository.getEmployees();
	private List<Department> departments = EmployeeRepository.getDepartments();
	

	// 14.6 Sum of all salaries
	    public double getTotalSalary() {
	        return employees.stream()
	                .mapToDouble(Employee::getSalary)
	                .sum();
	    }
	    
	// 14.7 Department names and count of employees
	      public Map<String, Long> getDepartmentEmployeeCounts() {
	          return employees.stream()
	                  .filter(e -> e.getDepartment() != null && e.getDepartment().getDepartmentName() != null)
	                  .collect(Collectors.groupingBy(e -> e.getDepartment().getDepartmentName(), Collectors.counting()));
	      }


	// 14.8 Senior-most employee
	       public Optional<Employee> getSeniorMostEmployee() {
	           return employees.stream()
	                   .min(Comparator.comparing(Employee::getHireDate));
	       }
   

    // 14.9 Employee name and duration of service
	        public Map<String, String> getEmployeeServiceDuration() {
	            return employees.stream()
	                    .collect(Collectors.toMap(
	                            Employee::getfullName,
	                            e -> {
	                                Period p = Period.between(e.getHireDate(), LocalDate.now());
	                                return p.getYears() * 12 + p.getMonths() + " months and " + p.getDays() + " days";
	                            }
	                    ));
	        }

	 // 14.10 Employees without department
	     public List<Employee> getEmployeesWithoutDepartment() {
	         return employees.stream()
	                 .filter(e -> e.getDepartment() == null)
	                 .collect(Collectors.toList());
	     }


	 // 14.11 Departments without employees
	  public List<Department> getDepartmentsWithoutEmployees() {
	      Set<Integer> deptIdsWithEmployees = employees.stream()
	              .filter(e -> e.getDepartment() != null)
	              .map(e -> e.getDepartment().getDepartmentId())
	              .collect(Collectors.toSet());

	      return departments.stream()
	              .filter(d -> !deptIdsWithEmployees.contains(d.getDepartmentId()))
	              .collect(Collectors.toList());
	  }


	// 14.12 Departments with highest count of employees

public List<String> getDepartmentsWithHighestEmployeeCount() {
    Map<String, Long> deptCounts = employees.stream()
            .filter(e -> e.getDepartment() != null && e.getDepartment().getDepartmentName() != null)
            .collect(Collectors.groupingBy(
                    e -> e.getDepartment().getDepartmentName(),
                    Collectors.counting()
            ));

    long max = deptCounts.values().stream().max(Long::compare).orElse(0L);

    return deptCounts.entrySet().stream()
            .filter(entry -> entry.getValue() == max)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
}


	

	// 14.13 Employee name, hire date, and day of week    

	public Map<String, String> getEmployeeHireDayInfo() {
	    return employees.stream()
	            .collect(Collectors.toMap(
	                    e -> e.getFirstName() + " " + e.getLastName(),
	                    e -> e.getHireDate().toString() + " (" +
	                         e.getHireDate().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + ")"
	            ));
	}



	// 14.14 Employees hired on a specific day (e.g., FRIDAY)
	public List<Employee> getEmployeesHiredOnDay(String dayName) {
	    return employees.stream()
	            .filter(e -> e.getHireDate().getDayOfWeek().name().equalsIgnoreCase(dayName))
	            .collect(Collectors.toList());
	}

	

	// 14.15 Employee name and manager name
	public List<String> getEmployeeManagerReport() {
	    Map<Integer, Employee> employeeMap = employees.stream()
	            .collect(Collectors.toMap(Employee::getEmployeeId, Function.identity()));
	
	    return employees.stream()
	            .filter(e -> e.getManagerId() != null)
	            .map(e -> {
	                Employee manager = employeeMap.get(e.getManagerId());
	                String managerName = (manager != null) ? manager.getFirstName() + " " + manager.getLastName() : "Unknown";
	                return e.getFirstName() + " " + e.getLastName() + " reports to " + managerName;
	            })
	            .collect(Collectors.toList());
	}


	//14.16 Employee name, salary, and 15% increased salary

	public Map<String, String> getSalaryWithIncrement() {
	    return employees.stream()
	            .collect(Collectors.toMap(
	                    e -> e.getFirstName() + " " + e.getLastName(),
	                    e -> {
	                        double increasedSalary = e.getSalary() * 1.15;
	                        return "Original: " + e.getSalary() + ", Increased: " + increasedSalary;
	                    }
	            ));
	}



	// 14.17 Employees without manager
	public List<Employee> getEmployeesWithoutManager() {
	    return employees.stream()
	            .filter(e -> e.getManagerId() == null)
	            .collect(Collectors.toList());
	}








}
