package com.example.teknologiinformasi.booking_service.event;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MovieCreatedEvent implements Serializable {
    private Long id;
    private String title;
    private String genre;
    private Double rating;
    private LocalDateTime createdAt;

    public MovieCreatedEvent() {}

    public MovieCreatedEvent(Long id, String title, String genre, Double rating, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
