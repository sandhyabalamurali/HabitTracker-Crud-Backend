# Use Eclipse Temurin JDK 17 image (official OpenJDK build)
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper if present, else skip
COPY mvnw .
COPY .mvn .mvn

# Copy the entire project
COPY . .

# Give permission to the Maven wrapper
RUN chmod +x mvnw

# Package the application (skip tests to save time)
RUN ./mvnw clean package -DskipTests

# Run the built JAR file
CMD ["java", "-jar", "target/HabitTracker-0.0.1-SNAPSHOT.jar"]
