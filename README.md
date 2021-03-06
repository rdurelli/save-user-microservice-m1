





<p align="center">
  

<h3 align="center">Microservice M1</h3>

  <p align="center">
    M1 is just responsible to validade and persist a user into the database. Then, a message is sent to the RabbitMQ (message-broker). All messages are put into a queue (FIFO).
    <br />
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>




<!-- ABOUT THE PROJECT -->
## About The Project
![alt text](https://github.com/rdurelli/save-user-microservice-m1/blob/main/image/arch.png?raw=true)
Nowadays there are a lot of micro-services out there. One way to accomplish the communication between them is by using message-broker, such as RabbitMQ Kafka.

I have created two isolate micro-services as can be seen in the figure. The first micro-service (M2) was devised using Java Spring Boot.

M1 is just responsible to validade and persist a user into the database. Then, a message is sent to the RabbitMQ (message-broker). All messages are put into a queue (FIFO).

The second micro-service (M2) was implemented using Go and some nice libs such as: (i) cobra to create a command line interface, (ii) Viper to read .env files, (iii) GIN to provide a web-service, and (iv) Gocron to trigger a task periodically.

M2 consumes the EMAIL queue as a message is ready. Then, the message is unmarshalled and a welcome email is sent to the added user. Then, information weather the email was correctly send or not is persisted into the database. Using Gocron a task periodically check if there is any email that wasn???t sent - if so, we try to send the email again.

#golang #Java #SpringBoot #go #docker #rabbitmq

Important links:

M1 GitHub: [link](https://github.com/rdurelli/save-user-microservice-m1.git)

M2 GitHub: [link](https://github.com/rdurelli/consumer-microservice-m2.git)


### Built With

* [Java]()
* [Spring-Boot](https://spring.io/projects/spring-boot)
* [Flyway](https://flywaydb.org/)
* [Docker](https://www.docker.com/)
* [Mysql]()
* [RabbitMQ](https://www.rabbitmq.com/)




<!-- GETTING STARTED -->
## Getting Started




To get a local copy up and running follow these simple steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* docker compose
  ```sh
  docker-compose up 
  ```

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/rdurelli/save-user-microservice-m1.git
   ```
2. Install pom.xml packages




<!-- USAGE EXAMPLES -->
## Usage

Start the SaveUserApplication.java. Then, call the following end-point to add an user: 

```
POST http://localhost:9090/users
```
###REQUEST
```
{
   "name": "Julia Fossaluzza",
   "lastName": "Durelli",
   "email" : "jubajuba.durelli@gmail.com",
   "password": "secret"
}
```
###RESPONSE
```
{
  "id": 15438,
  "name": "Julia Fossaluzza",
  "lastName": "Durelli",
  "email": "jubajuba.durelli@gmail.com",
  "created_date": "05/09/2021",
  "last_modified_date": "05/09/2021"
}
```


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Rafael S. Durelli - [@rafaeldurelli](https://twitter.com/rafaeldurelli) - rafael.durelli@ufla.br

Project Link: [https://github.com/rdurelli/save-user-microservice-m1.git](https://github.com/rdurelli/save-user-microservice-m1.git)
