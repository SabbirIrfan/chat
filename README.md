# chat# Chat App Backend (Spring Boot + MySQL)

This repository contains the backend code for a simple chat application built with Spring Boot and uses MySQL as the database. The backend provides RESTful API endpoints for user authentication, managing user profiles, and sending/receiving messages in real-time using WebSocket.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Configuration](#configuration)
  - [MySQL Database](#mysql-database)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [WebSocket Integration](#websocket-integration)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (e.g., OpenJDK 11)
- MySQL database server installed
- Your favorite Integrated Development Environment (IDE) for Java (e.g., IntelliJ IDEA, Eclipse)
- [Maven](https://maven.apache.org/) for managing dependencies

### Installation

1. Clone the repository:

   ```sh
   https://github.com/SabbirIrfan/chat/
2. Open the project in your IDE.

Configure your MySQL database connection in src/main/resources/application.properties. You can use the following properties as a starting point:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/chat_app_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

Build and run the application from your IDE or using the following command:

sh

mvn spring-boot:run
