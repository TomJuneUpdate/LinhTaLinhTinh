FROM openjdk:17-jdk-slim
VOLUME /tmp

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} backendapilinhtinh.jar

ENTRYPOINT ["java", "-jar", "/backendapilinhtinh.jar"]
EXPOSE 8080
