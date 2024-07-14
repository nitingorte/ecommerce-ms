package com.ecommerce.order.model.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PurchaseRequest {

    @NotNull(message = "product is mandatory")
    Integer productId;

    @Positive(message = "quantity is mandatory")
    double quantity;

}
