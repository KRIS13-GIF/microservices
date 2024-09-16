package com.example.microservices.customer;


import lombok.Data;

@Data
public class CustomerRequest {

    private String fistName;
    private String lastName;
    private String email;
}
