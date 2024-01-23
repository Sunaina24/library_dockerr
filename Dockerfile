# Use an official OpenJDK runtime as a base image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/Library-Management-0.0.1-SNAPSHOT.jar /app/app.jar

# Specify the command to run on container
CMD ["java", "-jar", "app.jar"]

EXPOSE 8244