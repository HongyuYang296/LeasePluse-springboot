# Use Gradle base image to build the jar file
FROM gradle:6.7-jdk11 as build
WORKDIR /app
# Copy build.gradle and source code
COPY build.gradle .
COPY src ./src
# Build the application
RUN gradle build -x test

# Use OpenJDK for the final image
FROM openjdk:11-jre-slim
WORKDIR /app
# Copy the built jar from the previous stage
COPY --from=build /app/build/libs/myapp-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
