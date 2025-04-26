package com.example.teknologiinformasi.repository;

import com.teknologiinformasi.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}