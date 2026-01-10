package com.example.scb_springboot.entity.movie;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Movie {
@Id
    @GeneratedValue
private Integer id;
private String title;
private Integer releaseYear;
private String genre;
private Float rating;

@ManyToMany(mappedBy = "movies")
private List<Actor> actors = new ArrayList();

public Movie() {}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Integer getReleaseYear() {
	return releaseYear;
}

public void setReleaseYear(Integer releaseYear) {
	this.releaseYear = releaseYear;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public Float getRating() {
	return rating;
}

public void setRating(Float rating) {
	this.rating = rating;
}

public List<Actor> getActors() {
	return actors;
}

public void setActors(List<Actor> actors) {
	this.actors = actors;
}

public Movie(Integer id, String title, Integer releaseYear, String genre, Float rating, List<Actor> actors) {
	super();
	this.id = id;
	this.title = title;
	this.releaseYear = releaseYear;
	this.genre = genre;
	this.rating = rating;
	this.actors = actors;
}

@Override
public String toString() {
	return "Movie [id=" + id + ", title=" + title + ", releaseYear=" + releaseYear + ", genre=" + genre + ", rating="
			+ rating + ", actors=" + actors + "]";
}


}
