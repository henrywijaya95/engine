FROM openjdk:11
EXPOSE 8083
ADD target/engine-docker.jar engine-docker.jar
ENTRYPOINT ["java", "-jar", "/engine-docker.jar"]