package com.example.scb_springboot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SportEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;
private String type;

@OneToMany(mappedBy = "sport",cascade = CascadeType.ALL, orphanRemoval = true)
private List<Player> players = new ArrayList();

public SportEntity(){
	
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

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public List<Player> getPlayers() {
	return players;
}

public void setPlayers(List<Player> players) {
	this.players = players;
}

public SportEntity(Long id, String name, String type, List<Player> players) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.players = players;
}

@Override
public String toString() {
	return "SportEntity [id=" + id + ", name=" + name + ", type=" + type + ", players=" + players + "]";
}

}
