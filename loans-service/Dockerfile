FROM eclipse-temurin:17-jammy

WORKDIR /app

COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

COPY target/micro-loans.jar /app/micro-loans.jar

EXPOSE 9092

CMD /wait-for-it.sh config-server:8071 -- java -jar /app/micro-loans.jar
