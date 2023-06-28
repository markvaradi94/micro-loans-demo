FROM eclipse-temurin:17-jammy

WORKDIR /app

COPY target/micro-loans.jar /app/micro-loans.jar

EXPOSE 9092

CMD ["java", "-jar", "/app/micro-loans.jar"]
