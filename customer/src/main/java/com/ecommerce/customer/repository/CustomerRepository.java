package com.ecommerce.customer.repository;

import com.ecommerce.customer.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {



}
