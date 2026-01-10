package com.example.scb_springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TouristDestination")
public class TouristDestination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "location")
	public String location;
	
	@Column(name = "description")
	public String description;
	
	public Integer visitorCount;
	
    public TouristDestination() {
		
	}

	public TouristDestination(Long id, String name, String location, String description, Integer visitorCount) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.description = description;
		this.visitorCount = visitorCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVisitorCount() {
		return visitorCount;
	}

	public void setVisitorCount(Integer visitorCount) {
		this.visitorCount = visitorCount;
	}

	@Override
	public String toString() {
		return "TouristDestination [id=" + id + ", name=" + name + ", location=" + location + ", description="
				+ description + ", visitorCount=" + visitorCount + "]";
	}

	}
