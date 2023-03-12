package com.ikon.kafkaorderservice.kafka;

import com.ikon.kafkabaseservice.dto.OrderEventDTO;
import lombok.Data;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Data
public class OrderProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderProducer.class);
    private NewTopic topic;
    private KafkaTemplate<String, OrderEventDTO> kafkaTemplate;

    public void sendMessage(OrderEventDTO event) {
        LOGGER.info(String.format("Order event => %s", event.toString()));

        Message<OrderEventDTO> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}
