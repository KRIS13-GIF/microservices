package com.example.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CustomerService {

    private final CustomerRepository customerRepository;

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer=Customer.builder()
                .firstName(customerRequest.getFistName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();

        customerRepository.save(customer);
    }
}
