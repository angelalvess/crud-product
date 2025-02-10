package com.angel.product.controller;


import com.angel.product.entity.ProductEntity;
import com.angel.product.entity.dto.ProductDTO;
import com.angel.product.entity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/{productId}")
    public ResponseEntity<Object> getProductById (@PathVariable("productId") UUID productId) {
        var product = productService.getProductById(productId);

        if (product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct (@RequestBody ProductDTO productDTO) {

        var product = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
