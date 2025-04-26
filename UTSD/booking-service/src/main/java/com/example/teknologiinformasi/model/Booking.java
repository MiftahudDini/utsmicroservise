package com.example.teknologiinformasi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private int quantity;
    private String status;
    private LocalDateTime createdAt;

    public Booking() {}

    public Booking(Long productId, int quantity, String status, LocalDateTime createdAt) {
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        this.createdAt = createdAt;
    }

    // getters & setters
}