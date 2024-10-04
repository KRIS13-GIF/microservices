package com.example.notifications;

import com.example.clients.notifications.NotificationRequest;
import com.example.clients.notifications.NotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("New Notification...{}", notificationRequest);
        notificationService.sentNotification(notificationRequest);
    }


    @GetMapping(path = "{customerId}")
    public NotificationResponse notificationResponse(@PathVariable("customerId") Integer customerId){
        notificationService.getNotification(customerId);
        return new NotificationResponse("DONE");
    }
}
