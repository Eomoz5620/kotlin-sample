FROM gradle:8.3-jdk17 as build
COPY . /app
WORKDIR /app
RUN gradle build --no-daemon

FROM openjdk:17
COPY --from=build /app/build/libs/*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
