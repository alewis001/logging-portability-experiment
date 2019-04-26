FROM jboss/wildfly:16.0.0.Final

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin1234 --silent
COPY ./target/logging-test.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]