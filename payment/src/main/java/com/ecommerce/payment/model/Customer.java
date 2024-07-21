package com.ecommerce.payment.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class Customer {
    String id;
    @NotNull(message = "firstName is required")
    String firstName;
    @NotNull(message = "lastName is required")
    String lastName;
    @NotNull(message = "email is required")
    @Email(message = "email is not formatted correctly")
    String email;
}
