package com.ikon.rabbitmqproducerservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RabbitMQProducerConsumerDTO {
    private Long id;
    private String name;
}
