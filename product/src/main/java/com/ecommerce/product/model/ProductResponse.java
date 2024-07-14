package com.ecommerce.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductResponse {
    Integer id;
    String name;
    String description;
    Double availableQuantity;
    BigDecimal price;

    Integer categoryId;
    String categoryName;
    String categoryDescription;
}
