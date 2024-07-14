package com.ecommerce.order.model.orderline;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderLineRequest {

    Integer id;
    Integer orderId;

    @NotNull(message = "product is mandatory")
    Integer productId;

    @Positive(message = "quantity is mandatory")
    double quantity;
}
