FROM openjdk:13-jdk-alpine
LABEL maintainer='isagiongo@gmail.com'
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} githubconsumer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/githubconsumer-0.0.1-SNAPSHOT.jar"]