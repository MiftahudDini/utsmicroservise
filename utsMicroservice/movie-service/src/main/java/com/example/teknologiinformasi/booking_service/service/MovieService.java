package com.example.teknologiinformasi.booking_service.service;

// import com.example.teknologiinformasi.model.Movie;
// import com.example.teknologiinformasi.booking_service.model.Movie;
// import com.example.teknologiinformasi.repository.MovieRepository;
import com.example.teknologiinformasi.booking_service.config.MovieRabbitConfig;
import com.example.teknologiinformasi.booking_service.event.MovieCreatedEvent;
import com.example.teknologiinformasi.booking_service.model.Movie;
import com.example.teknologiinformasi.booking_service.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id));
        movie.setTitle(movieDetails.getTitle());
        movie.setGenre(movieDetails.getGenre());
        movie.setRating(movieDetails.getRating());
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id));
        movieRepository.delete(movie);
    }
}
