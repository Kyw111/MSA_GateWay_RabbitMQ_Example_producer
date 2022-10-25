package com.rabbitmq.producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;


    public void send(String str) throws InterruptedException {
        for (int i = 1; i <= 1000; i++) {
            rabbitTemplate.convertAndSend("second.exchange", "rout.key", str);
            Thread.sleep(100);
            System.out.println(">>>> send " + str + i);
        }
    }
}
