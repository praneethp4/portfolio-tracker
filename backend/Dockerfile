# Step 1: Use a Java base image
FROM openjdk:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy Maven wrapper and project files
COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .

# Step 4: Make the Maven wrapper executable
RUN chmod +x mvnw               # Ensure the mvnw script is executable

# Step 5: Copy the source code into the container
COPY src/ ./src/

# Step 6: Resolve dependencies using Maven (via the wrapper)
RUN ./mvnw dependency:resolve   # Resolve dependencies with Maven wrapper

# Step 7: Package the application
RUN ./mvnw clean package -DskipTests  # Skip tests and package the app

# Step 8: Expose the application port (default Spring Boot port)
EXPOSE 8080

# Step 9: Define the command to run the Spring Boot app
CMD ["./mvnw", "spring-boot:run"]

# Optional: If you want to run a specific JAR file instead, you can use:
# CMD ["java", "-jar", "target/your-app-name.jar"]
