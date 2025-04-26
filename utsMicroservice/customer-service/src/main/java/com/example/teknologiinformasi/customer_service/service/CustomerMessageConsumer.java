package com.example.teknologiinformasi.customer_service.service;

import com.example.teknologiinformasi.customer_service.config.CustomerRabbitConfig;
import com.example.teknologiinformasi.customer_service.event.CustomerCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerMessageConsumer {

    @RabbitListener(queues = CustomerRabbitConfig.CUSTOMER_QUEUE)
    public void receiveCustomerEvent(CustomerCreatedEvent event) {
        // Tangani event CustomerCreatedEvent di sini
        System.out.println("Received CustomerCreatedEvent: " + event);
        // Logika yang ingin dilakukan setelah menerima event, misalnya simpan ke database
    }
}
