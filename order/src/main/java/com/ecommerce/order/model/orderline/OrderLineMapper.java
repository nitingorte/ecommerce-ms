package com.ecommerce.order.model.orderline;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.model.OrderLine;

public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.getId())
                .quantity(orderLineRequest.getQuantity())
                .order(
                        Order.builder()
                                .id(orderLineRequest.getOrderId())
                                .build()
                )
                .productId(orderLineRequest.getProductId())
                .build();
    }
}
