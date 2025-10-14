FROM icr.io/appcafe/open-liberty:kernel-slim-java17-openj9-ubi
COPY server.xml /config/server.xml
COPY ../../backend/apps/api-gateway/target/api-gateway.war /config/apps/api-gateway.war
CMD ["/opt/ol/wlp/bin/server", "run", "defaultServer"]
