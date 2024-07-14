package com.ecommerce.order.service;

import com.ecommerce.order.model.OrderRequest;

public interface OrderService {
    Integer createOrder(OrderRequest orderRequest);
}
