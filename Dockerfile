# Use a base image with Java 17
FROM openjdk:17-jdk-slim as build

WORKDIR /app

# Copy your build configuration files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Give execution rights on the gradlew
RUN chmod +x ./gradlew

# Build the application skipping tests
RUN ./gradlew build -x test

# Start with a clean, smaller runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
