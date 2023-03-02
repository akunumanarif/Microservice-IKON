package com.ikon.rabbitmqconsumerservice.controller;

import com.ikon.rabbitmqconsumerservice.config.RabbitConsumerConfig;
import com.ikon.rabbitmqconsumerservice.dto.RabbitMQProducerConsumerDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Data
@Component
@RequiredArgsConstructor
public class RabbitConsumerController {

    @RabbitListener(queues = RabbitConsumerConfig.QUEUE)
    public void consumerMessageFromQueue(RabbitMQProducerConsumerDTO rabbitMQProducerConsumerDTO){
        System.out.println("data = "+ rabbitMQProducerConsumerDTO.toString());
    }
}
