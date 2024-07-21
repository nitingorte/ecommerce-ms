package com.ecommerce.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentNotificationRequest {

    String orderReference;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerFirstName;
    String customerLastName;
    String customerEmail;

}
