FROM payara/server-full:6.2024.3
COPY domain.xml /opt/payara/appserver/glassfish/domains/domain1/config/domain.xml
COPY ../../backend/apps/api-gateway/target/api-gateway.war /opt/payara/appserver/glassfish/domains/domain1/autodeploy/api-gateway.war
