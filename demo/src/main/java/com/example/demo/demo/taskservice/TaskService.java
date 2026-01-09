package com.example.demo.demo.taskservice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.demo.taskmodel.TaskModel;
import com.example.demo.demo.taskrepository.TaskRepository;


@Service
public class TaskService {

	private TaskRepository taskRepository;
	
	TaskService(TaskRepository taskrepo)
	{
		this.taskRepository= taskrepo;
	}
	
	public TaskModel saveTask(TaskModel taskmodel)
	{
		return taskRepository.save(taskmodel);
	}
	
	public List<TaskModel> getalltask()
	{
		return taskRepository.findAll();
	}

	public Optional<TaskModel> getTaskById(Long id)
	{
		return taskRepository.findById(id);
	}
	
	public void deleteById(Long id)
	{
		Optional<TaskModel> t = taskRepository.findById(id);
		if(t.isPresent())
		{
			taskRepository.deleteById(id);
		}
		else {
		System.out.println("Task ID not found");
		}
		
	}
}
