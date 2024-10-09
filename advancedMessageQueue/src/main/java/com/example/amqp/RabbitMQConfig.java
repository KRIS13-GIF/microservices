package com.example.amqp;



import lombok.AllArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RabbitMQConfig {


    private final ConnectionFactory conncectionFactory;

/**Here is the shown the message which is being processed inside the queue.
When calling the POST endpoint, the queue receives the message and enqueues it inside the queue.
All the steps are done when the @Bean declaration is executed and the system is ready to process with the data.

 **/

    @Bean
    public TopicExchange internalExchange() {
        return new TopicExchange("internal-exchange");
    }

    // Queue Declaration
    @Bean
    public Queue notificationQueue() {
        return new Queue("notification.queue");
    }

    // Binding between Exchange and Queue with the routing key
    @Bean
    public Binding binding(Queue notificationQueue, TopicExchange internalExchange) {
        return BindingBuilder
                .bind(notificationQueue)
                .to(internalExchange)
                .with("internal.notification.routing-key");
    }


    @Bean
    //publich a message to a Queue -> Sends the messages to the queue as JSON
    public AmqpTemplate amqpTemplate(){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(conncectionFactory);

        rabbitTemplate.setMessageConverter(jacksonConverter());
        return rabbitTemplate;
    }



    //Receive the messages from the Queue
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(){
        SimpleRabbitListenerContainerFactory factory=new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(conncectionFactory);
        factory.setMessageConverter(jacksonConverter());
        return factory;
    }


    //converts to JSON
    @Bean
    public MessageConverter jacksonConverter(){
        MessageConverter jackson2JsonMessageConverter=
                new Jackson2JsonMessageConverter();
        return jackson2JsonMessageConverter;
    }

}
