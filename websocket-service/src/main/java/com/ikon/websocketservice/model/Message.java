package com.ikon.websocketservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Message {
    @JsonProperty
    private String content;

    public Message() {

    }

    public Message(String content) {
        this.content = content;
    }

}
