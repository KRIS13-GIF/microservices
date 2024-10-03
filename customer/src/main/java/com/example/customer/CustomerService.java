package com.example.customer;

import com.example.clients.fraud.FraudCheckResponse;
import com.example.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer=Customer.builder()
                .firstName(customerRequest.getFistName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();

        customerRepository.save(customer);


        //importing from the module and calling the microservice from the client
       FraudCheckResponse fraudCheckResponse= fraudClient.isFraudster(customer.getId());
       if (fraudCheckResponse.isFraud()){
           throw new IllegalStateException("Fraudster");
       }
    }
}
