# syntax=docker/dockerfile:1
FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/template-service-0.0.1-SNAPSHOT.jar
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw ./
COPY pom.xml ./
COPY src ./src
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
