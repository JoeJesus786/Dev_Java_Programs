package com.example.scb_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.scb_springboot.entity.Task;
import com.example.scb_springboot.repository.TaskRepository;


@Service
public class TaskService {
	
	private TaskRepository taskrepo;
	
	TaskService(TaskRepository repo){
		this.taskrepo = repo;
	}

	public Task saveTask(Task task) {
		return taskrepo.save(task);
	}

	public List<Task> getAllTask() {
		return taskrepo.findAll();
	}

	public Optional<Task> getTask(Long taskId) {
		return taskrepo.findById(taskId);
	}

	public void deleteTask(Long taskId) {
		Optional<Task> t = taskrepo.findById(taskId);
		if(t.isPresent()) {
        taskrepo.deleteById(taskId);	
		} else {
			
		}
	}



}
