package com.ecommerce.payment.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class PaymentRequest {

    Integer id;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    Integer orderId;
    String orderReference;
    Customer customer;
}
