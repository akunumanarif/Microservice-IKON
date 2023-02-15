package com.example.crudswagger.repository;

import com.example.crudswagger.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
