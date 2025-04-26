package com.example.teknologiinformasi.booking_service.controller;

// import com.example.teknologiinformasi.model.Movie;
// import com.example.teknologiinformasi.service.MovieService;
// import com.example.teknologiinformasi.model.Movie;
// import com.example.teknologiinformasi.service.MovieService;
import com.example.teknologiinformasi.booking_service.model.Movie;
import com.example.teknologiinformasi.booking_service.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        log.info("GET /api/movies accessed");
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        log.info("GET /api/movies/{} accessed", id);
        return movieService.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        log.info("POST /api/movies accessed with body: {}", movie);
        return movieService.createMovie(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        log.info("PUT /api/movies/{} accessed", id);
        try {
            Movie updatedMovie = movieService.updateMovie(id, movieDetails);
            return ResponseEntity.ok(updatedMovie);
        } catch (RuntimeException e) {
            log.warn("PUT /api/movies/{} failed: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteMovie(@PathVariable Long id) {
        log.info("DELETE /api/movies/{} accessed", id);
        try {
            movieService.deleteMovie(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Movie berhasil dihapus");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Movie tidak ditemukan dengan id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}