package com.example.scb_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scb_springboot.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	Task save(Task task);

}
