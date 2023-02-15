package com.example.crudswagger.controller;

import com.example.crudswagger.dto.ProductDTO;
import com.example.crudswagger.dto.ResponseDTO;
import com.example.crudswagger.entity.Product;
import com.example.crudswagger.service.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@Slf4j
@Data
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseDTO<Product>> addProduct(@RequestBody Product product, Errors errors) {

        ResponseDTO<Product> response = new ResponseDTO<>();
        if(errors.hasErrors()) {
            response.setMessage("Gagal menambahkan product");
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            response.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        response.setHttpStatus(HttpStatus.OK);
        response.setMessage("Product berhasil ditambahkan");
        log.info("Masuk sini");
        response.setData(productService.addProduct(product));
        log.info("Sampe sini kah?");

        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getOneProduct(@PathVariable("id") Long productId) {
        return productService.getOneProduct(productId);
    }

    @PutMapping
    public ResponseEntity<ResponseDTO<Product>> updateProduct(@RequestBody Product product, Errors errors) {
        ResponseDTO<Product> response = new ResponseDTO<>();
        if(errors.hasErrors()) {
            response.setMessage("Gagal mengupdate product");
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            response.setData(null);
        }
        response.setHttpStatus(HttpStatus.OK);
        response.setMessage("Product berhasil diupdate");
        response.setData(productService.addProduct(product));

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "Produk berhasil dihapus";
    }

}
