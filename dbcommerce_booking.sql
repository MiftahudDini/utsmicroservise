
-- Buat database
CREATE DATABASE IF NOT EXISTS dbcommerce_booking;
USE dbcommerce_booking;

-- Tabel Movie (dari model Movie.java)
CREATE TABLE IF NOT EXISTS movie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(100),
    rating DOUBLE
);

-- Tabel Booking (contoh sederhana, bisa disesuaikan)
CREATE TABLE IF NOT EXISTS booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id BIGINT NOT NULL,
    customer_name VARCHAR(255),
    booking_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (movie_id) REFERENCES movie(id) ON DELETE CASCADE
);
