FROM openjdk:17-jdk-slim
VOLUME /tmp
RUN apt-get update && apt-get install -y curl
COPY ./build/libs/*.jar analysis-service.jar
ENTRYPOINT ["java", "-jar", "/analysis-service.jar"]