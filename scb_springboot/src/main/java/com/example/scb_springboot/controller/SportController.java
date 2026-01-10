package com.example.scb_springboot.controller;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scb_springboot.dto.SportDTO;
import com.example.scb_springboot.entity.SportEntity;
import com.example.scb_springboot.repository.PlayerRepository;
import com.example.scb_springboot.repository.SportRepository;

@RestController
@RequestMapping("/sports")
public class SportController{
@Autowired
private SportRepository sportRepo;
@Autowired
private PlayerRepository playerRepo;

@PostMapping
public ResponseEntity<SportEntity> createSport(@RequestBody SportDTO dto) {
SportEntity sport = new SportEntity();
sport.setName(dto.name);
sport.setType(dto.type);
return new ResponseEntity<>(sportRepo.save(sport), HttpStatus.CREATED);
}

@GetMapping
public Page getAllSports(Pageable pageable) {
return (Page) sportRepo.findAll(pageable);
}

@GetMapping("/{id}")
public ResponseEntity<?> getSport(@PathVariable Long id) {
return sportRepo.findById(id)
.map(sport -> {
sport.getPlayers().size(); // force fetch
return ResponseEntity.ok(sport);
})
.orElse(ResponseEntity.notFound().build());
}

@PutMapping("/{id}")
public ResponseEntity<?> updateSport(@PathVariable Long id, @RequestBody SportDTO dto) {
return sportRepo.findById(id).map(sport -> {
sport.setName(dto.name);
sport.setType(dto.type);
return ResponseEntity.ok(sportRepo.save(sport));
}).orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteSport(@PathVariable Long id) {
return sportRepo.findById(id).map(sport -> {
if (!sport.getPlayers().isEmpty()) {
return ResponseEntity.status(HttpStatus.CONFLICT)
.body("Cannot delete sport with associated players.");
}
sportRepo.delete(sport);
return ResponseEntity.noContent().build();
}).orElse(ResponseEntity.notFound().build());
}

@GetMapping("/{id}/players")
public ResponseEntity<?> getPlayersBySport(@PathVariable Long id) {
if (!sportRepo.existsById(id)) {
return ResponseEntity.notFound().build();
}
return ResponseEntity.ok(playerRepo.findBySportId(id));
}
}
