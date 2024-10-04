package com.example.clients.notifications;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "notifications")
public interface NotificationClient {

    @GetMapping(path = "/api/v1/notification/{customerId}")
    NotificationResponse notificationResponse(@PathVariable("customerId") Integer customerId);
}
