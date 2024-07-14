package com.ecommerce.customer.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}
