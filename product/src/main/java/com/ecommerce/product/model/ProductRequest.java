package com.ecommerce.product.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    Integer id;
    @NotNull(message = "product name is required")
    String name;
    @NotNull(message = "product description is required")
    String description;
    @Positive(message = "available quantity should be positive")
    Double availableQuantity;
    @Positive(message = "price should be positive")
    BigDecimal price;
    @Positive(message = "category should be positive")
    Integer categoryId;
}
