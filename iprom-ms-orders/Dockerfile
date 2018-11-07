FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/iprom-ms-orders-1.0.0-SNAPSHOT.jar
ADD ${JAR_FILE} iprom-ms-orders.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/iprom-ms-orders.jar"]
