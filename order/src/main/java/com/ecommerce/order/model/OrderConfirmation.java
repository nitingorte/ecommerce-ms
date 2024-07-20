package com.ecommerce.order.model;

import com.ecommerce.order.model.customer.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderConfirmation {
    String orderReference;
    BigDecimal totalAmount;
    PaymentMethod paymentMethod;
    CustomerResponse customerResponse;
    List<PurchaseResponse> products;
}
