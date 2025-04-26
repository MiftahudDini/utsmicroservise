package com.example.teknologiinformasi.booking_service.service;

import com.example.teknologiinformasi.booking_service.config.MovieRabbitConfig;
import com.example.teknologiinformasi.booking_service.event.MovieCreatedEvent;
// import com.example.teknologiinformasi.config.MovieRabbitConfig;
// import com.example.teknologiinformasi.event.MovieCreatedEvent;
import com.example.teknologiinformasi.booking_service.model.Movie;
import com.example.teknologiinformasi.booking_service.service.MovieService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MovieMessageConsumer {

    @RabbitListener(queues = MovieRabbitConfig.MOVIE_QUEUE)
    public void receiveMovieCreatedEvent(MovieCreatedEvent event) {
        System.out.println("Movie Service received MovieCreatedEvent: " + event);
        // Tambahkan logika tambahan jika perlu
    }
}