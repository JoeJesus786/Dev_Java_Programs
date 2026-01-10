package com.example.scb_springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "title")
	public String title;
	
	@Column(name = "description")
	public String description;
	
	public int priority;
	
	public Task() {
		
	}

	public Task(Long id, String title, String description, int priority) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.priority = priority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "TaskEntity [id=" + id + ", title=" + title + ", description=" + description + ", priority=" + priority
				+ "]";
	}
	
	
	

}
