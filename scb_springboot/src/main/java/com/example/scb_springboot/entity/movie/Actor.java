package com.example.scb_springboot.entity.movie;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Actor {
@Id
@GeneratedValue
private Integer id;
private String firstName;
private String lastName;
private Integer birthYear;

@ManyToMany
@JoinTable(
name = "actor_movie",
joinColumns = @JoinColumn(name = "actor_id"),
inverseJoinColumns = @JoinColumn(name = "movie_id")
)
private List<Movie> movies = new ArrayList<>();

public Actor() {}

public Actor(Integer id, String firstName, String lastName, Integer birthYear, List<Movie> movies) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.birthYear = birthYear;
	this.movies = movies;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
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

public Integer getBirthYear() {
	return birthYear;
}

public void setBirthYear(Integer birthYear) {
	this.birthYear = birthYear;
}

public List<Movie> getMovies() {
	return movies;
}

public void setMovies(List<Movie> movies) {
	this.movies = movies;
}

@Override
public String toString() {
	return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthYear=" + birthYear
			+ ", movies=" + movies + "]";
}


}
