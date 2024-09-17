FROM openjdk:17-jdk-slim

WORKDIR /app


COPY target/twowatch-serv-eureka-0.0.1-SNAPSHOT.jar eureka-ms-server.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","eureka-ms-server.jar"]