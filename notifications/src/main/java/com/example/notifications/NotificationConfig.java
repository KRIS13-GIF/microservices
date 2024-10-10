package com.example.notifications;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration
public class NotificationConfig {

    //these are all linked to the application.yml file

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;


    //Define the Topic Exchange
    @Bean
    public TopicExchange internalTopicExchange(){
        return new TopicExchange(this.internalExchange);
    }


    //Define the queue
    @Bean
    public Queue notificationQueue(){
        return new Queue(this.notificationQueue);
    }

    //Binding these two together (the queue and the Topic exchange)
    @Bean
    public Binding internalNotificationBinding(){
        return BindingBuilder.bind(notificationQueue())
                .to(internalTopicExchange())
                .with(this.internalNotificationRoutingKey); // the routing key used for the binding
    }




    public String getInternalExchange() {
        return internalExchange;
    }

    public String getNotificationQueue() {
        return notificationQueue;
    }

    public String getInternalNotificationRoutingKey() {
        return internalNotificationRoutingKey;
    }
}*/
