FROM openliberty/open-liberty:kernel-java8-openj9

COPY ./docker/openliberty/server.xml /config/
COPY ./target/logging-test.war /config/dropins

# Setting the context-param in web.xml is not 
# sufficient in OpenLiberty. As such, need to 
# use the jvm.options to keep the application
# portable.
COPY ./docker/openliberty/jvm.options /config/

COPY ./docker/log4j2.xml /etc/logging-test/

EXPOSE 8080