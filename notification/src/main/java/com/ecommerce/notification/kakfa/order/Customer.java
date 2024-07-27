package com.ecommerce.notification.kakfa.order;

import lombok.Data;

@Data
public class Customer {

    String id;
    String firstname;
    String lastname;
    String email;
}
