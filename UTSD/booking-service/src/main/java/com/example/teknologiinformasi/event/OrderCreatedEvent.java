package com.example.teknologiinformasi.event;
import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderCreatedEvent implements Serializable {
    private Long id;
    private Long productId;
    private int quantity;
    private LocalDateTime createdAt;
    private String orderStatus;

    public OrderCreatedEvent() {}

    public OrderCreatedEvent(Long id, Long productId, int quantity, LocalDateTime createdAt, String orderStatus) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.orderStatus = orderStatus;
    }

    // getters & setters
}
