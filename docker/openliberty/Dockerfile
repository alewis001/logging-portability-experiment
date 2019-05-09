FROM openliberty/open-liberty:kernel-java8-openj9

COPY ./docker/openliberty/server.xml /config/
COPY ./target/logging-test.war /config/dropins

EXPOSE 8080