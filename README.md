# spring-cloud-bus-config-server
![alt text](https://github.com/smartinrub/spring-centralized-configuration/blob/master/spring_cloud_config_server.png)

With webhook

![alt text](https://github.com/smartinrub/spring-centralized-configuration/blob/master/spring_cloud_config_server_webhook.png)

# Getting Started
## RabbitMQ

```shell script
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```

`3-management` version contains the management RabbitMQ plugin and the 
UI can be accessed at `localhost:15672`.


## Spring Cloud Config Server

Once the config-server is running properties can be retrieved at `localhost:8888/{service-client-name}/{profile}`.

e.g.

```shell script
curl localhost:8888/first-client/development
```

## Spring Cloud Config Client

- Clients run at ports `8081` and `8082`.
- To refresh properties and reload the classes marked with `@RefreshScope`:

```shell script
curl -X POST localhost:{server-port}/actuator/refresh
```

- To refresh properties in all the services (only one request to one of the services):

```shell script
curl -X POST localhost:{server-port}/actuator/bus-refresh
```
