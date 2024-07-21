package com.ecommerce.order.payment;

import com.ecommerce.order.model.PaymentMethod;
import com.ecommerce.order.model.customer.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PaymentRequest {

    BigDecimal amount;
    PaymentMethod paymentMethod;
    Integer orderId;
    String orderReference;
    CustomerResponse customer;

}
