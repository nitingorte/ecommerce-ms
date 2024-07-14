package com.ecommerce.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
//@RequiredArgsConstructor
@AllArgsConstructor
public class ProductPurchaseResponse {
    Integer productId;
    String name;
    String description;
    BigDecimal price;
    Double quantity;
}
