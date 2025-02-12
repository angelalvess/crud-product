package com.angel.product.controller;


import com.angel.product.entity.ProductEntity;
import com.angel.product.entity.dto.ProductDTO;
import com.angel.product.entity.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/{productId}")
    public ResponseEntity<Object> getProductById (@PathVariable("productId") UUID productId) {
        var product = productService.getProductById(productId);

        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts () {
        var product = productService.getAllProducts();


        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct (@RequestBody @Valid ProductDTO productDTO) {

        var product = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PutMapping("update/{productId}")
    public ResponseEntity<Object> updateProductById ( @Valid @PathVariable("productId")  UUID productId, @RequestBody ProductDTO productDTO) {


        var updateProduct = productService.updateProductById(productId, productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);

    }
}
