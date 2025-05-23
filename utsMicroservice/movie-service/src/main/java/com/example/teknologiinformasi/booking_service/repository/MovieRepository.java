package com.example.teknologiinformasi.booking_service.repository;

import com.example.teknologiinformasi.booking_service.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
