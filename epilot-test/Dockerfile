FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package


EXPOSE 8080
CMD ["java", "-jar", "target/epilot-test-0.0.1-SNAPSHOT.jar"]