package com.ecommerce.notification.kakfa.order;

import com.ecommerce.notification.kakfa.payment.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderConfirmation {
    String orderReference;
    BigDecimal totalAmount;
    PaymentMethod paymentMethod;
    Customer customer;
    List<Product> products;

}
