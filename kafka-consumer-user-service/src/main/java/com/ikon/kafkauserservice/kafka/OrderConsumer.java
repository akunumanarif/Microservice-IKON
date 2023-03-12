package com.ikon.kafkauserservice.kafka;

import com.ikon.kafkabaseservice.dto.OrderEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    private void consume(OrderEventDTO event) {
        LOGGER.info(String.format("Order event received in user service => %s", event.toString()));

    }
}
