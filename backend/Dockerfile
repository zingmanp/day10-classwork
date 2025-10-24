# Stage1: this is to build the app

FROM maven:3.8.6-openjdk-11 as build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvnclean package -DskipTests

# Stage 2: This run the jar file

FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=build /app/target/demo-1.0.0.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
