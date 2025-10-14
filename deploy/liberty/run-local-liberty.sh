#!/usr/bin/env bash
set -euo pipefail
mvn -P liberty package
SERVER_DIR=${SERVER_DIR:-$(pwd)}
${LIBERTY_HOME:-/opt/ol/wlp}/bin/server run defaultServer
