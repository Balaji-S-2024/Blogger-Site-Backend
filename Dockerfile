tep 1: Use a Java runtime as base image

FROM openjdk:17-jdk-slim



# Step 2: Set working directory in the container

WORKDIR /app



# Step 3: Copy the Spring Boot fat JAR into the container

COPY target/*.jar app.jar



# Step 4: Expose the port (Render will assign dynamic PORT)

EXPOSE 8080



# Step 5: Run the JAR file

ENTRYPOINT ["java","-jar","app.jar"]


