package com.example.scb_springboot.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scb_springboot.entity.movie.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {}
