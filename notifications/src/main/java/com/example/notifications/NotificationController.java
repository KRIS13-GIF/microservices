package com.example.notifications;

import com.example.clients.notifications.NotificationResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @GetMapping(path = "{customerId}")
    public NotificationResponse notificationResponse(@PathVariable("customerId") Integer customerId){
        notificationService.getNotification(customerId);
        return new NotificationResponse("DONE");
    }
}
