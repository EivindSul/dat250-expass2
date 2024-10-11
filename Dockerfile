FROM gradle:8-jdk21 AS builder

COPY . .

RUN ./gradlew bootJar
RUN mv backend/build/libs/backend-0.0.1-SNAPSHOT.jar app.jar

FROM eclipse-temurin:21-alpine

RUN addgroup -g 1000 pollapp
RUN adduser -G pollapp -D -u 1000 -h /pollapp pollapp

USER pollapp
WORKDIR /pollapp

COPY --from=builder --chown=1000:1000 /home/gradle/app.jar .

CMD ["java", "-jar", "app.jar"]
