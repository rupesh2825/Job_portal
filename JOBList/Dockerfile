# ---------- Stage 1: Build the Spring Boot App ----------
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app

# Copy all project files
COPY . .

# Build the app and skip tests for faster build
RUN mvn clean package -DskipTests

# ---------- Stage 2: Run the App ----------
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your app will run on
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
