package com.example.teknologiinformasi.customer_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerRabbitConfig {

   public static final String CUSTOMER_EXCHANGE = "customer.exchange";
   public static final String CUSTOMER_QUEUE = "customer.created.queue";
   public static final String CUSTOMER_ROUTING_KEY = "customer.created";

   @Bean
   public DirectExchange customerExchange() {
       return new DirectExchange(CUSTOMER_EXCHANGE);
   }

   @Bean
   public Queue customerQueue() {
       return new Queue(CUSTOMER_QUEUE);
   }

   @Bean
   public Binding customerBinding(Queue customerQueue, DirectExchange customerExchange) {
       return BindingBuilder.bind(customerQueue).to(customerExchange).with(CUSTOMER_ROUTING_KEY);
   }

   @Bean
   public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
       return new Jackson2JsonMessageConverter();
   }
}
