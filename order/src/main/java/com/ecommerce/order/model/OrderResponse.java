package com.ecommerce.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderResponse {
    Integer id;
    String reference;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerId;
}
