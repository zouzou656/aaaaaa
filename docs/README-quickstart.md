# Stratum Platform Quickstart

Stratum is a Jakarta EE and React based ESB for ISO 20022 integrations. This quickstart covers local builds.

## Prerequisites

- Java 17, 21, or 22
- Maven 3.9+
- Node.js 18+

## Build Backend

```bash
mvn -P liberty package
```

## Run Liberty Profile

Use the provided Dockerfile:

```bash
cd deploy/liberty
docker build -t stratum-liberty .
docker run -p 9080:9080 stratum-liberty
```

## Frontend

```bash
cd frontend/web-console
npm install
npm run dev
```
