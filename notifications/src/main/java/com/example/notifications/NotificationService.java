package com.example.notifications;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service

public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public String getNotification(Integer customerId){
        notificationRepository.save(Notification.builder()
                        .CustomerId(customerId)
                        .message("DONE")
                        .createdAt(LocalDate.from(LocalDateTime.now())).
                        build());
        return  "yes";
    }

}
