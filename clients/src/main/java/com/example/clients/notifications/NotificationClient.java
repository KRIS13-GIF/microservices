package com.example.clients.notifications;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notifications")
public interface NotificationClient {

   /* @GetMapping(path = "/api/v1/notification/{customerId}")
    NotificationResponse notificationResponse(@PathVariable("customerId") Integer customerId);*/


    @PostMapping("api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);

}
