FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/notebook-execution-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8087

ENTRYPOINT ["java","-jar","app.jar"]
