FROM openjdk:17-jdk-slim
VOLUME /tmp

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} backendshop.jar

ENTRYPOINT ["java", "-jar", "/backendshop.jar"]
EXPOSE 8080
