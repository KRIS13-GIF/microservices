package com.example.microservices.customer;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private Integer id;
    private String fistName;
    private String lastName;
    private String email;

}
