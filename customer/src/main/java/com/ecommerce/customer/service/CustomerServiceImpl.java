package com.ecommerce.customer.service;

import com.ecommerce.customer.Entity.Customer;
import com.ecommerce.customer.exception.CustomerNotFoundException;
import com.ecommerce.customer.model.CustomerMapper;
import com.ecommerce.customer.model.CustomerRequest;
import com.ecommerce.customer.model.CustomerResponse;
import com.ecommerce.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public String createCustomer(CustomerRequest customerRequest) {
        var customer = customerRepository.save(customerMapper.toCustomer(customerRequest));
        return customer.getId();
    }

    @Override
    public void updateCustomer(CustomerRequest customerRequest) {
        var customer = customerRepository.findById(customerRequest.getId())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot found customer:: No customer found with ID:: %s", customerRequest.getId())));
        mergeCustomer(customer, customerRequest);
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existsById(String customerId) {
        return customerRepository.findById(customerId).isPresent();
    }

    @Override
    public CustomerResponse findById(String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(format("No Customer found with provided ID:: %s", customerId)));
    }

    @Override
    public void deleteById(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private void mergeCustomer(Customer customer, CustomerRequest customerRequest) {
        if (StringUtils.isNotBlank(customerRequest.getFirstName()))
            customer.setFirstName(customerRequest.getFirstName());

        if (StringUtils.isNotBlank(customerRequest.getLastName()))
            customer.setLastName(customerRequest.getLastName());

        if (StringUtils.isNotBlank(customerRequest.getEmail()))
            customer.setLastName(customerRequest.getEmail());

        if (customerRequest.getAddress() != null)
            customer.setAddress(customerRequest.getAddress());
    }
}
