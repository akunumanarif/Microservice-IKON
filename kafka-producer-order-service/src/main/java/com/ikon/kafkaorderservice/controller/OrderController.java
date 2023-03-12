package com.ikon.kafkaorderservice.controller;

import com.ikon.kafkabaseservice.dto.OrderDTO;
import com.ikon.kafkabaseservice.dto.OrderEventDTO;
import com.ikon.kafkaorderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody OrderDTO order) {
        order.setOrderId(UUID.randomUUID().toString());

        OrderEventDTO orderEventDTO = new OrderEventDTO();
        orderEventDTO.setStatus("PENDING");
        orderEventDTO.setMessage("Order status is pending!");
        orderEventDTO.setOrderDTO(order);

        orderProducer.sendMessage(orderEventDTO);

        return "Order has been placed successfully...";
    }
}
