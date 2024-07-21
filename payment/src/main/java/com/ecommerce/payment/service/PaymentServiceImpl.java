package com.ecommerce.payment.service;

import com.ecommerce.payment.config.NotificationProducer;
import com.ecommerce.payment.mapper.PaymentMapper;
import com.ecommerce.payment.model.PaymentNotificationRequest;
import com.ecommerce.payment.model.PaymentRequest;
import com.ecommerce.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest paymentRequest) {
        var payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        paymentRequest.getOrderReference(),
                        paymentRequest.getAmount(),
                        paymentRequest.getPaymentMethod(),
                        paymentRequest.getCustomer().getFirstName(),
                        paymentRequest.getCustomer().getLastName(),
                        paymentRequest.getCustomer().getEmail()
                )
        );
        return payment.getId();
    }

}
