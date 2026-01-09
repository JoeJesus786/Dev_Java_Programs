package com.example.demo.demo.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

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

import com.example.demo.demo.taskmodel.TaskModel;
import com.example.demo.demo.taskservice.TaskService;


@RestController
@RequestMapping("/tasks")
public class Controller {
	
	@Autowired
	TaskService service;
	
	@PostMapping
	public ResponseEntity<TaskModel> addtask(@RequestBody TaskModel model)
	{
		TaskModel addmodel = service.saveTask(model);
		return new ResponseEntity<TaskModel>(addmodel,HttpStatus.CREATED);
	}
	

	@GetMapping()
	public ResponseEntity<List<TaskModel>> getAllTask()
	{
		List<TaskModel> alltasklists = service.getalltask();
		List<TaskModel> sortedlist = alltasklists.stream().sorted(Comparator.comparing(TaskModel::getId).reversed()).toList();
		return new ResponseEntity<List<TaskModel>>(alltasklists,HttpStatus.OK);
		
	}
	
	@GetMapping("/{taskid}")
	public ResponseEntity<TaskModel> getTaskdetailsbyId(@PathVariable("taskid") Long id)
	{
		Optional<TaskModel> taskdetailswithid = service.getTaskById(id);
		if(taskdetailswithid==null)
		{
			return new ResponseEntity(taskdetailswithid,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(taskdetailswithid,HttpStatus.OK);
	}
	
	@DeleteMapping("/{taskid}")
	public ResponseEntity<TaskModel> deleteDetailsbyId(@PathVariable("taskid") Long id)
	{
		 service.deleteById(id);
		return new ResponseEntity(null,HttpStatus.NOT_FOUND);
	}

}
