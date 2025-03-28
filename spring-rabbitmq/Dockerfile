# Use the official OpenJDK 8 image as a base
FROM openjdk:8-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/service-1-1.0-SNAPSHOT.jar /app/app.jar

# Expose the port that your Spring Boot app will run on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
