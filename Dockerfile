FROM gradle:8.5.0-jdk21-alpine as builder
WORKDIR /app
COPY src /app/.
RUN gradle build

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app/*.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/*.jar"]