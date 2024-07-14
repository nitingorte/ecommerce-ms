package com.ecommerce.order.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseResponse {

    Integer productId;
    String name;
    String description;
    BigDecimal price;
    Double quantity;
}
