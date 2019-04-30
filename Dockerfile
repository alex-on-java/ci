FROM openjdk:8-jdk-alpine
COPY backend/target/ci-test-*.jar app.jar
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "-Xmx256m", "app.jar"]
EXPOSE 8080