package com.angel.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;


@Entity
@Table(name = "tb_product")
public class ProductEntity {


    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID product_id;

    private String name;

    private Double price;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    private Instant updateTimeStamp;

    public ProductEntity () {
    }

    public ProductEntity (String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public UUID getProduct_id () {
        return product_id;
    }

    public void setProduct_id (UUID product_id) {
        this.product_id = product_id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice (Double price) {
        this.price = price;
    }

    public Instant getCreationTimeStamp () {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp (Instant creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Instant getUpdateTimeStamp () {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp (Instant updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }
}
