package com.rabbitmq.producer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rabbitmq.producer.service.RabbitMQProducer;

@EnableRabbit
@RestController
@RequiredArgsConstructor
@RequestMapping("/rabbit")
public class ProducerAPI {

    private final RabbitMQProducer rabbitMQProducer;
    private final String RETURN_MSG = "send!";


    @PostMapping
    public ResponseEntity sendMsg(@RequestBody String msg) throws InterruptedException {
        rabbitMQProducer.send(msg);
        return ResponseEntity.ok().body(RETURN_MSG);
    }

}
