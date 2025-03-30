# Use a Java 21 base image for the build stage
FROM maven:3.8.5-openjdk-21 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the entire project into the container
COPY . /app/

# Build the Spring Boot application using Maven
RUN mvn clean install -DskipTests

# Use a Java 21 base image for the runtime stage
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the runtime stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port your Spring Boot application runs on (typically 8080)
EXPOSE 8080

# Run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]