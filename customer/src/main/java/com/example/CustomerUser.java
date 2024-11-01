package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.example.customer",
                "com.example.amqp"  //ability to inject the RabbitMQMessagesProducer
        }
)
@EnableDiscoveryClient
@EnableFeignClients(
        basePackages = "com.example.clients"
)
public class CustomerUser {
    public static void main(String[] args) {

        SpringApplication.run(CustomerUser.class, args);
    }
}