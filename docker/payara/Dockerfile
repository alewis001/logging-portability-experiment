FROM payara/server-full:5.184

COPY ./target/logging-test.war $DEPLOY_DIR
COPY ./docker/log4j2.xml /etc/logging-test/

EXPOSE 8080