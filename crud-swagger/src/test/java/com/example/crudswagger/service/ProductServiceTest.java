package com.example.crudswagger.service;

import com.example.crudswagger.entity.Product;
import com.example.crudswagger.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository);
    }

    @Test
    void testGetAllProducts() {

        // ? Arrange
        Product product = new Product(1L, "Bakso", "Bakso sapi", 10, 100.000);
        Product product2 = new Product(1L, "Soto", "Soto ayam", 10, 100.000);

        when(productRepository.findAll()).thenReturn(Arrays.asList(product, product2));

        // ? Act
        Iterable<Product> products = productService.getAllProducts();

        verify(productRepository, times(1)).findAll();

        // ? Assert
        assertEquals(2, ((Collection<?>) products).size());

    }

    @Test
    void testGetOneProduct() {
        // ? Arrange
        Product product = new Product(1L, "Bakso", "Bakso sapi", 10, 100.000);
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        // ? Act
        Product optProduct = productService.getOneProduct(product.getId());

        // ? Assert
        assertNotNull(optProduct);
        assertEquals(product, optProduct);
    }

    @Test
    void testAddProduct() {

        // ? Arrange
        Product productSent = new Product(null, "Bakso", "Bakso sapi", 10, 100.000);
        Product productSaved = new Product(1L, "Bakso", "Bakso sapi", 10, 100.000);

        when(productRepository.save(productSent)).thenReturn(productSaved);

        // ? Act
        Product savedProduct = productService.addProduct(productSent);

        verify(productRepository, times(1)).save(productSent);

        // ? Assert
        assertEquals(productSaved, savedProduct);

    }

    @Test
    void testDeleteProduct() {

        // ? Arrange
        Long productId = 1L;

        // ? Act
        productService.deleteProduct(productId);

        // ? Assert
        assertNotNull(productId);
        verify(productRepository, times(1)).deleteById(productId);



    }


}