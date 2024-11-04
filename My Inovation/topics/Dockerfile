# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build file and install dependencies
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN ./mvnw dependency:resolve

# Copy the project source code to the container
COPY src ./src

# Package the application (run the Maven package phase)
RUN ./mvnw package -DskipTests

# Expose the port that the application will run on
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "target/topics-0.0.1-SNAPSHOT.jar"]
