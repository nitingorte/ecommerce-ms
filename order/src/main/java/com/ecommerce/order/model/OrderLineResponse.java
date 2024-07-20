package com.ecommerce.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderLineResponse {

    Integer id;
    double quantity;

}
