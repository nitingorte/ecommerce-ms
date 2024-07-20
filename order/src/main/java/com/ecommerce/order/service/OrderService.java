package com.ecommerce.order.service;

import com.ecommerce.order.model.OrderRequest;
import com.ecommerce.order.model.OrderResponse;

import java.util.List;

public interface OrderService {
    Integer createOrder(OrderRequest orderRequest);

    List<OrderResponse> findAll();

    OrderResponse findById(Integer orderId);
}
