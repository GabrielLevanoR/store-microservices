
# Spring Boot & Spring Cloud

Microservices project following the Online Store proposal of https://github.com/digitallab-academy/ms-course-youtube, updating it to the Spring Boot 3.2.2 version and replacing dependencies that are no longer supported.


### Requirements

To test the project you must have at least

* Spring Boot 3.2.2
* Java 17
* Maven

### Dependencies

* Lombok
* Resilience4j - CircuitBreaker
* Actuator
* Eureka
* JPA
* Starter Config
* Starter Validation
* Admin Client Starter
* H2 Database Engine
* OpenFeign

### How to use

To test the project, you must fork this repository and you must also have a GitHub SSH key. For more information on how to generate and add one, review the documentation https://docs.github.com/en/authentication/connecting-to-github-with-ssh

Once you have the key, you must replace the SSH URL of your repository in the file: 

`microservice-config/src/main/resources/application.yml`

```yml
spring:
  application:
    name: config-server
  cloud:
    config:
      server:
        git:
          uri: <your_ssh_url>
          search-paths: config-data
  security:
    user: root
    password: pass4u
```

### Ports

* msvc-eureka - `http://localhost:8761`
* config-server - `http://root:pass4u@localhost:8888`
* gateway-service - `http://localhost:8080`

You can check the configurations with `http://localhost:8888/` name and `/default`, for example: 

`http://root:pass4u@localhost:8888/msvc-customer/default`

* msvc-product - `http://localhost:8090`
* msvc-shopping - `http://localhost:8091`
* msvc-customer - `http://localhost:9090`

Additionally, you can see the microservices registry and additional information in `http://localhost:9097/applications`