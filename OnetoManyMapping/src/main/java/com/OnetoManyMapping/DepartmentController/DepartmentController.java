package com.OnetoManyMapping.DepartmentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnetoManyMapping.Repository.DepartmentRepository;
import com.OnetoManyMapping.model.Department;
import com.OnetoManyMapping.model.Employee;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping
	public Department createDepartment(@RequestBody Department department)
	{
		List<Employee> employees = department.getEmployees();
		if(employees != null) {
		for(Employee emp : employees)
		{
			emp.setDepartment(department);
		}
		}
		return departmentRepository.save(department);
	}
	
	@GetMapping
	public List<Department> getAllDepartments()
	{
		return departmentRepository.findAll();
	}
	
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id)
	{
		if(departmentRepository.existsById(id))
		{
			departmentRepository.deleteById(id);
			return ResponseEntity.ok("Department deleted successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not fount");
		}
	}
}
