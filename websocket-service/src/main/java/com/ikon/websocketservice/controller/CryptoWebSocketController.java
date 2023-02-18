package com.ikon.websocketservice.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class CryptoWebSocketController {
    private final SimpMessagingTemplate messagingTemplate;

    public CryptoWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/market-data/BTC")
    public void handleMarketData(String message) {
        // process the incoming message and send the updated data to subscribed clients
        String updatedData = "New market data for BTC: " + message;
        messagingTemplate.convertAndSend("/topic/market-data/BTC", updatedData);
    }
}
