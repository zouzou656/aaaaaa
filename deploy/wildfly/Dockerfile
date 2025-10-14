FROM quay.io/wildfly/wildfly:30.0.0.Final
COPY standalone-full.xml /opt/jboss/wildfly/standalone/configuration/standalone-full.xml
COPY ../../backend/apps/api-gateway/target/api-gateway.war /opt/jboss/wildfly/standalone/deployments/api-gateway.war
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-full.xml"]
