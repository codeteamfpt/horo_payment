# syntax=docker/dockerfile:1
FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=out/artifacts/horo_payment_jar/*.jar
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw ./
COPY pom.xml ./
COPY src ./src
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
