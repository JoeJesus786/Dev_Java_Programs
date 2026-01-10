package com.OnetoManyMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnetoManyMapping.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
