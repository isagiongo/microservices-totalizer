FROM openjdk:13-jdk-alpine
LABEL maintainer='isagiongo@gmail.com'
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} twitter-consumer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/twitter-consumer-0.0.1-SNAPSHOT.jar"]