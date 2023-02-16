package com.example.crudswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CrudSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSwaggerApplication.class, args);
    }

}
