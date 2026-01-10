package com.example.scb_springboot.controller.movie;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scb_springboot.entity.movie.Actor;
import com.example.scb_springboot.entity.movie.Movie;
import com.example.scb_springboot.repository.movie.ActorRepository;
import com.example.scb_springboot.repository.movie.MovieRepository;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired private ActorRepository actorRepo;
    @Autowired private MovieRepository movieRepo;

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody
    		Actor actor) {
        Actor saved = actorRepo.save(actor);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return actorRepo.findAll(Sort.by("id"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActor(@PathVariable Integer id) {
        return actorRepo.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{actorId}/movies")
    public ResponseEntity<List<Movie>> getMoviesByActor(@PathVariable Integer actorId) {
        return actorRepo.findById(actorId)
            .map(actor -> ResponseEntity.ok(actor.getMovies().stream()
                .sorted(Comparator.comparing(Movie::getId))
                .collect(Collectors.toList())))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{actorId}/movies")
    public ResponseEntity<?> assignMoviesToActor(@PathVariable Integer actorId, @RequestBody List<Integer> movieIds) {
        Optional<Actor> actorOpt = actorRepo.findById(actorId);
        if (actorOpt.isEmpty()) return ResponseEntity.notFound().build();

        List<Movie> movies = movieRepo.findAllById(movieIds);
        if (movies.size() != movieIds.size()) return ResponseEntity.notFound().build();

        Actor actor = actorOpt.get();
        actor.setMovies(movies);
        actorRepo.save(actor);

        for (Movie movie : movies) {
            if (!movie.getActors().contains(actor)) {
                movie.getActors().add(actor);
                movieRepo.save(movie);
            }
        }

        return ResponseEntity.ok().build();
    }
}
