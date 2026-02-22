# Use lightweight Java runtime
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/todo-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render overrides with PORT env)
EXPOSE 8080

# Run Spring Boot app
ENTRYPOINT ["java","-jar","/app/app.jar"]