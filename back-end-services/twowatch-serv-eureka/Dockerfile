FROM amazoncorretto:21
LABEL author="gabrieljustino"

WORKDIR /app
COPY target/twowatch-serv-eureka-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","app.jar"]