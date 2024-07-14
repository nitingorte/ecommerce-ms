package com.ecommerce.order.model;

import com.ecommerce.order.model.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequest {

    Integer id;
    String reference;

    @Positive(message = "order amount should be positive")
    BigDecimal amount;

    @NotNull(message = "payment method should be precised")
    PaymentMethod paymentMethod;

    @NotNull(message = "customer should be present")
    @NotBlank(message = "customer should be present")
    @NotEmpty(message = "customer should be present")
    String customerId;

    @NotEmpty(message = "you should at least purchase one product")
    List<PurchaseRequest> products;
}
