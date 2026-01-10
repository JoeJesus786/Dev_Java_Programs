package com.example.scb_springboot.controller.movie;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/movies")
public class MovieController {
    @Autowired private MovieRepository movieRepo;
    @Autowired private ActorRepository actorRepo;

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie saved = movieRepo.save(movie);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepo.findAll(Sort.by("id"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
        return movieRepo.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{movieId}/actors")
    public ResponseEntity<?> assignActorsToMovie(@PathVariable Integer movieId, @RequestBody List<Integer> actorIds) {
        Optional<Movie> movieOpt = movieRepo.findById(movieId);
        if (movieOpt.isEmpty()) return ResponseEntity.notFound().build();

        List<Actor> actors = actorRepo.findAllById(actorIds);
        if (actors.size() != actorIds.size()) return ResponseEntity.notFound().build();

        Movie movie = movieOpt.get();
        movie.setActors(actors);
        movieRepo.save(movie);

        for (Actor actor : actors) {
            if (!actor.getMovies().contains(movie)) {
                actor.getMovies().add(movie);
                actorRepo.save(actor);
            }
        }

        return ResponseEntity.ok().build();
    }
}
