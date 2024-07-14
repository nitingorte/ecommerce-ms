package com.ecommerce.customer.service;

import com.ecommerce.customer.model.CustomerRequest;
import com.ecommerce.customer.model.CustomerResponse;

import java.util.List;

public interface CustomerService {
    String createCustomer(CustomerRequest customerRequest);

    void updateCustomer(CustomerRequest customerRequest);

    List<CustomerResponse> findAllCustomers();

    Boolean existsById(String customerId);

    CustomerResponse findById(String customerId);

    void deleteById(String customerId);
}
