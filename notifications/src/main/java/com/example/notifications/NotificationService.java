package com.example.notifications;

import com.example.clients.notifications.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service

public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }



    public void sentNotification(NotificationRequest notificationRequest){
        notificationRepository.save(
                Notification.builder().
                        toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("Kris Beka")
                        .message(notificationRequest.message())
                        .createdAt(LocalDate.from(LocalDateTime.now())).build()
        );

    }

    public String getNotification(Integer customerId){
        notificationRepository.save(Notification.builder()
                        .toCustomerId(customerId)
                        .message("DONE")
                        .createdAt(LocalDate.from(LocalDateTime.now())).
                        build());
        return  "yes";
    }

}
