# sb-rabbitmq-mcs

![Logo](https://github.com/gugafromMARS/sb-rabbitmq-mcs/assets/116969206/0e81fe59-45cf-43b3-bb5d-14f75813b434)


Welcome, this is a simple exercise for pratice Rabbitmq with exchange in microservices, the theme of exercise is orders are sent to exchange and exchange choose with the routing keys for which queue is going to send email or stock service.


## Architecture

![ArchitectureImg](https://github.com/gugafromMARS/sb-rabbitmq-mcs/assets/116969206/10918db4-042d-4178-b261-0d0d9ca08827)


## Technology

Here are some technologys used on this project.

* Java version 17
* RabbitMQ

## Services

Services used.

* Github
  
## Getting started

1- Run this command on terminal for start a container with RabbitMQ
```shell script
docker run -d -p 15672:15672 -p 5672:5672 --hostname my-rabbitmq --name my-rabbitmq-container rabbitmq:3.13.0-rc.2-management
```
## App functionalitys

In this project you have only on option :

* **Send Order**
You have a controller in order microservice thats your producer who going to send order to exchange.

## Authors

**gugafromMars**

[Github-gugafromMars](https://github.com/gugafromMARS)

Thanks to visiting and happy coding!
