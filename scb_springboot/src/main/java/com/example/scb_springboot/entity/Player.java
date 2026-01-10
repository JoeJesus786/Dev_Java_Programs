package com.example.scb_springboot.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Player {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String firstName;
private String lastName;
private LocalDate dateOfBirth;

@ManyToOne
@JoinColumn(name = "sport_id", nullable = false)
private SportEntity sport;

public Player() {
	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public LocalDate getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public SportEntity getSport() {
	return sport;
}

public void setSport(SportEntity sport) {
	this.sport = sport;
}

public Player(Long id, String firstName, String lastName, LocalDate dateOfBirth, SportEntity sport) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.sport = sport;
}

@Override
public String toString() {
	return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
			+ ", sport=" + sport + "]";
}
}
