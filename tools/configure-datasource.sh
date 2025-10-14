#!/usr/bin/env bash
set -euo pipefail
curl -sS -X POST http://localhost:9080/api/admin/datasources \
  -H 'Content-Type: application/json' \
  -d '{"name":"jdbc/PlatOps","xa":true,"jdbcUrl":"jdbc:postgresql://localhost:5432/platops"}'
