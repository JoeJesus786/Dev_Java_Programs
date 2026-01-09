package com.example.demo.demo.taskmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Task")
public class TaskModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(name="Taskname")
	public String taskname;
	
	@Column(name="TaskDetails")
	public String taskdetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskdetails() {
		return taskdetails;
	}

	public void setTaskdetails(String taskdetails) {
		this.taskdetails = taskdetails;
	}

	public TaskModel(Long id, String taskname, String taskdetails) {
		super();
		this.id = id;
		this.taskname = taskname;
		this.taskdetails = taskdetails;
	}

	public TaskModel() {
		super();
	}

	@Override
	public String toString() {
		return "TaskModel [id=" + id + ", taskname=" + taskname + ", taskdetails=" + taskdetails + "]";
	}
	
	
}
