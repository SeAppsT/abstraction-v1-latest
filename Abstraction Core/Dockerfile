FROM openjdk:13
COPY ./target/abstraction-2.0.1-SNAPSHOT.jar .
WORKDIR .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "abstraction-2.0.1-SNAPSHOT.jar"]