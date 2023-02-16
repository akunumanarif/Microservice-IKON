package com.example.crudswagger.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
//    private Integer stock;
//    private Double price;

}
