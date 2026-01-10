package com.OnetoManyMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnetoManyMapping.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
