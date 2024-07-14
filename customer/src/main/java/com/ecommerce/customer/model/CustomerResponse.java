package com.ecommerce.customer.model;

import com.ecommerce.customer.Entity.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    String id;
    String firstName;
    String lastName;
    String email;
    Address address;
}
