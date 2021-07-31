FROM openjdk
RUN mkdir -p /app
COPY ./target/dwjdbiapp-1.0-SNAPSHOT.jar /app
COPY ./config.yml /app
# WORKDIR /app
CMD ["java" "-jar" "/app/dwjdbiapp-1.0-SNAPSHOT.jar" "server" "/app/config.yml"]
