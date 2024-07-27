package com.ecommerce.notification.kakfa.payment;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentConfirmation {

    String orderReference;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerFirstname;
    String customerLastname;
    String customerEmail;
}
