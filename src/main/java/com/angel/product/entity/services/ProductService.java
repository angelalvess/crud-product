package com.angel.product.entity.services;

import com.angel.product.entity.ProductEntity;
import com.angel.product.entity.dto.ProductDTO;
import com.angel.product.infra.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public ProductEntity createProduct (ProductDTO productDTO) {
        var productModel = new ProductEntity();
        BeanUtils.copyProperties(productDTO, productModel);
        return productRepository.save(productModel);
    }

    public Optional<ProductEntity> getProductById (UUID productId) {
        return productRepository.findById(productId);

    }

    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<ProductEntity> updateProductById ( UUID id,  ProductDTO productDTO) {

        var productId = productRepository.findById(id);


        BeanUtils.copyProperties(productDTO, productId.get());
        productRepository.save(productId.get());

        return productId;
    }

}
