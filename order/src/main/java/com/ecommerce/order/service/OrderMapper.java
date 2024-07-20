package com.ecommerce.order.service;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.model.OrderRequest;
import com.ecommerce.order.model.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequest orderRequest){
        return Order.builder()
                .id(orderRequest.getId())
                .customerId(orderRequest.getCustomerId())
                .reference(orderRequest.getReference())
                .totalAmount(orderRequest.getAmount())
                .paymentMethod(orderRequest.getPaymentMethod())
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
