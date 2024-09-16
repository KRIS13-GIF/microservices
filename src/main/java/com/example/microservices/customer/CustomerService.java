package com.example.microservices.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer=Customer.builder()
                .fistName(customerRequest.getFistName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();

    }
}
