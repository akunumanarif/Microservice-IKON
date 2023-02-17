package com.ikon.websocketservice.controller;

import com.ikon.websocketservice.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public Message greet(Message message) throws Exception {
        Thread.sleep(1000);
        return new Message("Your message: " + message.getContent());
    }
}
