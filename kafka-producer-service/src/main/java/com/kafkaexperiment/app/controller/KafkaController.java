package com.kafkaexperiment.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

@RestController
public class KafkaController {
    private static final Logger logger =
            LoggerFactory.getLogger(KafkaController.class);

    private final KafkaTemplate<String, Object> template;
    private final String topicName;
    private final int messagesPerRequest;
    private CountDownLatch latch;

    public KafkaController(
            final KafkaTemplate<String, Object> template,
            @Value("${tpd.topic-name}") final String topicName,
            @Value("${tpd.messages-per-request}") final int messagesPerRequest) {
        this.template = template;
        this.topicName = topicName;
        this.messagesPerRequest = messagesPerRequest;
    }

    @GetMapping("/order")
    public String order() throws Exception {
        //latch = new CountDownLatch(messagesPerRequest);
        IntStream.range(0, messagesPerRequest)
                .forEach(i -> this.template.send(topicName, String.valueOf(i), "Order item no-"+i));
        //latch.await(10, TimeUnit.SECONDS);
        logger.info("All messages received");
        return "New order has been created!";
    }

    @GetMapping("/user")
    public String user() throws Exception {
        //latch = new CountDownLatch(messagesPerRequest);
        IntStream.range(0, messagesPerRequest)
                .forEach(i -> this.template.send(topicName, String.valueOf(i), "User no-"+i));
        //latch.await(10, TimeUnit.SECONDS);
        logger.info("All messages received");
        return "Order from user has been received!";
    }

    @GetMapping("/product")
    public String product() throws Exception {
        //latch = new CountDownLatch(messagesPerRequest);
        IntStream.range(0, messagesPerRequest)
                .forEach(i -> this.template.send(topicName, String.valueOf(i), "Product no-"+i));
        //latch.await(10, TimeUnit.SECONDS);
        logger.info("All messages received");
        return "Order for new product has been received!";
    }

    @GetMapping("/hello")
    public String hello() throws Exception {
        // to enable messaging delay (sync operation), uncomment code below

        //latch = new CountDownLatch(messagesPerRequest);
        IntStream.range(0, messagesPerRequest)
                .forEach(i -> this.template.send(topicName, String.valueOf(i), "Ini pesan ke-"+i));
        //latch.await(10, TimeUnit.SECONDS);
        logger.info("All messages received");
        return "Hello Kafka!";
    }
}
