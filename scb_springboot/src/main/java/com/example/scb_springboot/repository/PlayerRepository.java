package com.example.scb_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scb_springboot.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
List<Player> findBySportId(Long sportId);
}

