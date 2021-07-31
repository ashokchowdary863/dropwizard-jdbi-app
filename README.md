# Dropwizard JDBI App

PS : This project is just for beginner who wants to get started with Dropwizard and JDBI
I haven't followed best practices :P, Just wrote whatever in my mind...


How to start the Dropwizard Trails application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dwjdbiapp-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

DB Schema
---
DB schema is placed in schema.sql

Docker
---

```shell
mvn clean install
docker build . -t myapp
docker run -p 8080:8080 -p 8081:8081 --net=host myapp 
```