# Use the Gradle image to build the app
FROM openjdk:17-jdk-slim as build

# Set the working directory
WORKDIR /app

# Copy Gradle wrapper and project files
COPY gradlew ./
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Make the Gradle wrapper executable and run bootJar
RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar -x test  # This will create an executable JAR

# Production image
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
