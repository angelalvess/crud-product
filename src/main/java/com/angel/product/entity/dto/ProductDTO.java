package com.angel.product.entity.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductDTO(@NotBlank String name, @Min(1) Double price) {
}
