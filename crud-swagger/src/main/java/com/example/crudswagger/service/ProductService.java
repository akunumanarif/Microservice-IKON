package com.example.crudswagger.service;

import com.example.crudswagger.entity.Product;
import com.example.crudswagger.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getOneProduct(Long productId) {
        Optional<Product> productTemp = productRepository.findById(productId);

        if (!productTemp.isPresent()) {
            return null;
        }
        return productRepository.findById(productId).get();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

}
