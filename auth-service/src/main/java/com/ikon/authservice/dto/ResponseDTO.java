package com.ikon.authservice.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponseDTO<T> implements Serializable {

    private HttpStatus httpStatus;
    private String message;
    private T data;
}
