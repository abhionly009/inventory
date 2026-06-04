# Inventory Service

## Overview

The **Inventory Service** is a Spring Boot microservice responsible for managing product inventory across the system. It provides functionality to create inventory records, update stock levels, increase or reduce available quantities, and maintain accurate inventory information.

The service follows a microservices architecture and uses Apache Kafka for asynchronous communication with other services such as Order Service and Product Service.

---

## Features

- Add products to inventory
- Update inventory details
- Increase product stock
- Reduce product stock during order processing
- Check inventory availability
- Retrieve inventory information
- Delete inventory records
- Kafka-based event-driven communication
- RESTful APIs
- MySQL database integration
- Exception handling and validation

---

## Technology Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Web
- Apache Kafka
- MySQL
- Maven
- Lombok
- Docker
- JUnit
- Mockito

---

## Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── kafka
├── exception
└── config
```

---

## Responsibilities

### Inventory Management

- Create inventory records
- Update inventory information
- Delete inventory records
- Fetch inventory details

### Stock Management

- Increase stock quantity
- Reduce stock quantity
- Validate inventory availability
- Prevent negative stock updates

### Event Processing

- Consume order-related events
- Publish inventory-related events
- Maintain
