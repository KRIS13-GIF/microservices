package com.example.notifications.rabbitmq;


import com.example.clients.notifications.NotificationRequest;
import com.example.notifications.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;


    @RabbitListener(queues = "notification.queue") // calling the queue from where you are taking the notification
    public void consumer(NotificationRequest notificationRequest){
      log.info("Consumed from {} queue", notificationRequest);
      notificationService.sentNotification(notificationRequest); // here you send the notification after you have submitted it from the Customer
    }
}
