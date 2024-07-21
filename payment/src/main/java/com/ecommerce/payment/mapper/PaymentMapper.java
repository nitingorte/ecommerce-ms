package com.ecommerce.payment.mapper;

import com.ecommerce.payment.entity.Payment;
import com.ecommerce.payment.model.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment toPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .id(paymentRequest.getId())
                .orderId(paymentRequest.getOrderId())
                .paymentMethod(paymentRequest.getPaymentMethod())
                .amount(paymentRequest.getAmount())
                .build();
    }
}
