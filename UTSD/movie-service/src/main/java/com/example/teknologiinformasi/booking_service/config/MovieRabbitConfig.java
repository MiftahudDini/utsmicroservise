package com.example.teknologiinformasi.booking_service.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieRabbitConfig {

    public static final String MOVIE_EXCHANGE = "movie.exchange";
    public static final String MOVIE_QUEUE = "movie.created.queue";
    public static final String MOVIE_ROUTING_KEY = "movie.created";

    @Bean
    public DirectExchange movieExchange() {
        return new DirectExchange(MOVIE_EXCHANGE);
    }

    @Bean
    public Queue movieQueue() {
        return new Queue(MOVIE_QUEUE);
    }

    @Bean
    public Binding movieBinding(Queue movieQueue, DirectExchange movieExchange) {
        return BindingBuilder.bind(movieQueue).to(movieExchange).with(MOVIE_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
