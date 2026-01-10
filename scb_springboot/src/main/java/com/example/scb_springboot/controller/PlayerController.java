package com.example.scb_springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.scb_springboot.dto.PlayerDTO;
import com.example.scb_springboot.entity.Player;
import com.example.scb_springboot.entity.SportEntity;
import com.example.scb_springboot.repository.PlayerRepository;
import com.example.scb_springboot.repository.SportRepository;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepo;

    @Autowired
    private SportRepository sportRepo;

    @PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody PlayerDTO dto) {
        Optional<SportEntity> sport = sportRepo.findById(dto.sportId);
        if (sport.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sport not found.");
        }
        Player player = new Player();
        player.setFirstName(dto.firstName);
        player.setLastName(dto.lastName);
        player.setDateOfBirth(dto.dateOfBirth);
        player.setSport(sport.get());
        return new ResponseEntity<>(playerRepo.save(player), HttpStatus.CREATED);
    }

    @GetMapping
    public org.springframework.data.domain.Page<Player> getAllPlayers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "firstName") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return playerRepo.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable Long id) {
        return playerRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO dto) {
        return playerRepo.findById(id).map(player -> {
            Optional<SportEntity> sport = sportRepo.findById(dto.sportId);
            if (sport.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sport not found.");
            }
            player.setFirstName(dto.firstName);
            player.setLastName(dto.lastName);
            player.setDateOfBirth(dto.dateOfBirth);
            player.setSport(sport.get());
            return ResponseEntity.ok(playerRepo.save(player));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long id) {
        return playerRepo.findById(id).map(player -> {
            playerRepo.delete(player);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/sport")
    public ResponseEntity<?> getSportByPlayer(@PathVariable Long id) {
        return playerRepo.findById(id)
                .map(player -> ResponseEntity.ok(player.getSport()))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/switch-sport/{newSportId}")
    public ResponseEntity<?> switchSport(@PathVariable Long id, @PathVariable Long newSportId) {
        Optional<Player> playerOpt = playerRepo.findById(id);
        Optional<SportEntity> sportOpt = sportRepo.findById(newSportId);

        if (playerOpt.isEmpty() || sportOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player or Sport not found.");
        }

        Player player = playerOpt.get();
        player.setSport(sportOpt.get());
        return ResponseEntity.ok(playerRepo.save(player));
    }
}

