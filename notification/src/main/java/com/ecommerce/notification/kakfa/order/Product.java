package com.ecommerce.notification.kakfa.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    Integer productId;
    String name;
    String description;
    BigDecimal price;
    double quantity;
}
