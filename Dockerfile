FROM openjdk:8
EXPOSE 8080
ADD target/elastic-docker.jar elastic-docker.jar
ENTRYPOINT ["java","-jar","/elastic-docker.jar"]