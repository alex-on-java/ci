FROM maven:3.5.3-jdk-8-alpine
WORKDIR /build

# We need this user because embeded Postges haven't been running under root
RUN addgroup -S gr && adduser -S nonroot -G gr
RUN chown nonroot .
USER nonroot

COPY backend .

ENTRYPOINT ["mvn"]
CMD ["package"]