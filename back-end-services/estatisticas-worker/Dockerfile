FROM amazoncorretto:21
LABEL author="gabrieljustino"

WORKDIR /app


COPY target/estatisticas-worker-0.0.1-SNAPSHOT.jar /app/app.jar


ENTRYPOINT ["java","-jar","app.jar"]