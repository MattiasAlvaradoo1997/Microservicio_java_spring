FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/microservicio1-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
