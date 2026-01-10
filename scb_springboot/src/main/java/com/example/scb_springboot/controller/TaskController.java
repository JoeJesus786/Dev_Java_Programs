package com.example.scb_springboot.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.scb_springboot.entity.Task;
import com.example.scb_springboot.service.TaskService;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@PostMapping
	public ResponseEntity<Task> saveTask(@RequestBody Task task) {
		Task savedRecord = taskService.saveTask(task);
		return new ResponseEntity(savedRecord,HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getAll() {
		List<Task> taskList = taskService.getAllTask();
		List<Task> sortedList = taskList.stream().sorted(Comparator.comparing(Task::getPriority).reversed()).toList();
		return new ResponseEntity(sortedList,HttpStatus.OK);
	}
	
	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getTask(@PathVariable("taskId") Long taskId) {
		Optional<Task> fetchedTask = taskService.getTask(taskId);
		if(fetchedTask == null) {
			return new ResponseEntity(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(fetchedTask,HttpStatus.OK);
	}
	
	@DeleteMapping("/{taskId}")
	public ResponseEntity<Task> deleteTask(@PathVariable("taskId") Long taskId) {
		  
		 taskService.deleteTask(taskId);
		return new ResponseEntity(null,HttpStatus.NO_CONTENT);
	}
	
}
