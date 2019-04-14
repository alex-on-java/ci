FROM maven:3.5.3-jdk-8-alpine AS build
WORKDIR /build

# We need this user because embeded Postges haven't been running under root
RUN addgroup -S gr && adduser -S nonroot -G gr
RUN chown nonroot .
USER nonroot

# cache most of the dependencies
COPY backend/pom.xml .
RUN mvn dependency:resolve

COPY backend/src ./src
RUN mvn package

FROM openjdk:8-jdk-alpine
COPY --from=build /build/target/calculator-*.jar app.jar
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "-Xmx256m", "app.jar"]
EXPOSE 8080