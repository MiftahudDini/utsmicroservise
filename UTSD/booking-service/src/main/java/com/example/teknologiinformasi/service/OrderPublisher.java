package com.example.teknologiinformasi.service;

import com.teknologiinformasi.bookingservice.config.BookingRabbitConfig;
import com.teknologiinformasi.bookingservice.event.OrderCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderPublisher {

    private final RabbitTemplate rabbitTemplate;

    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrderCreatedEvent(OrderCreatedEvent event) {
        rabbitTemplate.convertAndSend(BookingRabbitConfig.ORDER_EXCHANGE, BookingRabbitConfig.ORDER_ROUTING_KEY, event);
        System.out.println("Booking Service mengirim OrderCreatedEvent: " + event);
    }
}