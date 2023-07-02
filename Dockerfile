
FROM openjdk:17-jdk-alpine3.12


WORKDIR /app


COPY target/Oracletest1-4.0.1.jar /app/Oracletest1-4.0.1.jar
COPY config.yml /app/config.yml


EXPOSE 8080


CMD ["java", "-jar", "Oracletest1-4.0.1.jar", "server", "config.yml"]