FROM openjdk:11-jre-slim

WORKDIR /app

COPY build/libs/fat.jar betclic-players.jar

EXPOSE 8080

CMD ["java", "-jar", "betclic-players.jar"]
