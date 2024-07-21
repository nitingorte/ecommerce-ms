package com.ecommerce.payment.service;

import com.ecommerce.payment.model.PaymentRequest;

public interface PaymentService {
    Integer createPayment(PaymentRequest paymentRequest);
}
