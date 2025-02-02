# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and project files
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# Download dependencies
RUN ./mvnw dependency:resolve

# Copy the source code
COPY src ./src

# Package the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Set the JAR file to run
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
