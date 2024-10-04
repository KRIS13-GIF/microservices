package com.example.clients.fraud;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//match the controller fraud. Has accesses to the api in the FRAUD Controller
@FeignClient("fraud")
public interface FraudClient {

    @GetMapping(path = "/api/v1/fraud/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
