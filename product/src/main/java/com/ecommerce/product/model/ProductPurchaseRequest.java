package com.ecommerce.product.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductPurchaseRequest {

    @NotNull(message = "product is mandatory")
    Integer productId;
    @NotNull(message = "quantity is mandatory")
    Double quantity;
}
