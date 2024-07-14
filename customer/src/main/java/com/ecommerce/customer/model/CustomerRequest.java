package com.ecommerce.customer.model;

import com.ecommerce.customer.Entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequest {
    String id;
    @NotNull(message = "customer first-name is required")
    String firstName;
    @NotNull(message = "customer last-name is required")
    String lastName;
    @NotNull(message = "customer email is required")
    @Email(message = "customer email is not valid")
    String email;
    Address address;
}
