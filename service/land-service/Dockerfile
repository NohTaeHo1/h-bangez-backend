FROM openjdk:17-jdk-slim
VOLUME /tmp
RUN apt-get update && apt-get install -y curl
COPY ./build/libs/*.jar land-service.jar
ENTRYPOINT ["java", "-jar", "/land-service.jar"]