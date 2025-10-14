#!/usr/bin/env bash
set -euo pipefail
mvn -P wildfly package
${WILDFLY_HOME:-/opt/jboss/wildfly}/bin/standalone.sh -c standalone-full.xml
