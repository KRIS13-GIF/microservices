package com.example.customer;

import com.example.amqp.RabbitMQMessageProducer;
import com.example.clients.fraud.FraudCheckResponse;
import com.example.clients.fraud.FraudClient;
import com.example.clients.notifications.NotificationClient;
import com.example.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFistName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();

        customerRepository.save(customer);

        log.info("Customer is registered !");

        //importing from the module and calling the microservice from the client
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraud()) {
            throw new IllegalStateException("Fraudster");
        } else {
            /*//send a notification based on a logic. If customer is not a FraudSter send the notification
            NotificationResponse notificationResponse = notificationClient.notificationResponse(customer.getId());
            if (notificationResponse == null) {
                throw new IllegalStateException("The notification is not created");*/

            NotificationRequest notificationRequest=new NotificationRequest(
                    customer.getId(),
                    customer.getEmail(),
                    customer.getFirstName());

            /*notificationClient.sendNotification(
                notificationRequest

            );*/


            //Using RabbitMQ to put the request inside of the QUEUE-> No more need for notificationClient
            rabbitMQMessageProducer.publish(  // the same as sending notifications
                    notificationRequest,
                    "internal-exchange",
                    "internal.notification.routing-key"
            );
            log.info("Sent");




            }
        }
    }
