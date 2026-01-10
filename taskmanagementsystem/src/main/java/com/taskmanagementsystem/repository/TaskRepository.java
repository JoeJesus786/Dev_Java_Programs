package com.taskmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagementsystem.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
