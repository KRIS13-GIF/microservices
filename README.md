# Microservices Architecture with Message Queue and Distributed Tracing

---

## Load Balancer
Acts as the gateway for external users to access services. It manages traffic and routes requests to internal services, ensuring reliability and even distribution of load.

## Microservices

- **Fraud Service**  
  Responsible for fraud detection. Communicates with other services asynchronously to send notifications and stores data in a MongoDB instance.

- **Customer Service**  
  Manages customer-related operations, with data stored in PostgreSQL. It also interacts with other services asynchronously for notifications.

- **Notification Service**  
  Sends notifications using external providers like Twilio and Firebase. It uses RabbitMQ and Kafka for asynchronous message handling and stores data in a PostgreSQL instance.

## Broker

Utilizes **RabbitMQ** and **Kafka** for message brokering to handle asynchronous notifications. This setup helps decouple services, allowing them to interact without direct dependencies and supporting scalability.

## Database

- **MongoDB** for the Fraud Service
- **PostgreSQL** for the Customer and Notification Services

## Private Docker Registry

Stores Docker images for microservices. Each service can pull images as needed to create containers, maintaining a consistent deployment environment.

## Service Discovery and Configuration

- **Eureka Server**: Acts as the service registry, allowing services to discover each other dynamically.
- **Config Server**: Centralized environment configuration management, allowing services to pull configurations, which can be managed through GitHub or similar version control.

## Distributed Tracing

**Zipkin** with Sleuth integration enables distributed tracing across services, making it easier to monitor and troubleshoot transactions spanning multiple services.

---

![Microservices Architecture Diagram](https://github.com/user-attachments/assets/90060b93-b261-4a14-8e04-cb9854f86515)
