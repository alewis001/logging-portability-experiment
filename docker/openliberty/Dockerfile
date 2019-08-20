# Start with OL runtime.
FROM open-liberty:kernel-java11

# Configure the features and JVM settings for the Server
COPY ./docker/openliberty/server.xml /config/

# Add the Zipkin Opentracing feature to OL
COPY ./docker/openliberty/extension /opt/ol/wlp/usr/extension

# Copy in the application
COPY ./target/logging-test.war /config/apps

# Set WORKDIR to enable hot-deploy of the war via skaffold
WORKDIR /