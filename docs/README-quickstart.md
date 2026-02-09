# Stratum Platform Quickstart

Stratum is a Jakarta EE and React based ESB for ISO 20022 integrations. This quickstart explains how to build and run the platform on a developer workstation.

## 1. Prerequisites

| Component | Version | Notes |
|-----------|---------|-------|
| Java Development Kit | 17, 21, or 22 | Configure Maven Toolchains to point at the installed JDKs (see `.mvn/toolchains.xml`). |
| Apache Maven | 3.9+ | Used for all backend builds. |
| Node.js | 18+ | Used for the React web console. |
| Docker | 20+ (optional) | Required only if you want to run the provided Liberty container profile. |
| Open Liberty | 23.0.0.12+ (optional) | Needed for the host-installed server scripts under `deploy/liberty`. |
| PostgreSQL & ActiveMQ Artemis | Latest LTS (optional) | Local infrastructure for advanced demos. Testcontainers will launch ephemeral instances for integration tests. |

> **Tip:** `sdkman`, `asdf`, or Homebrew make it easy to install multiple JDK versions for the Maven toolchain matrix.

## 2. Clone the Repository

```bash
git clone https://github.com/your-org/stratum.git
cd stratum
```

## 3. Configure Environment Variables (Optional)

Set the following variables if you plan to reuse an existing Liberty install or want to override defaults:

```bash
export LIBERTY_HOME=/path/to/wlp
export STRATUM_DB_URL="jdbc:postgresql://localhost:5432/stratum"
export STRATUM_DB_USER=stratum
export STRATUM_DB_PASSWORD=stratum
```

If you do not set `LIBERTY_HOME`, the run scripts expect Liberty to be available at `/opt/ol/wlp` inside the Docker container.

## 4. Build the Backend

Run a full backend build against the default Liberty profile. This uses the Maven toolchain to target Java 17 bytecode while still compiling on any supported JDK.

```bash
mvn -P liberty clean package
```

The build produces WAR files for each Jakarta EE application under `backend/apps/*/target/` and aggregates shared libraries from the `backend/platform-*` modules.

## 5. Start Supporting Services (Optional but Recommended)

For richer demos you can start PostgreSQL, ActiveMQ Artemis, and Keycloak locally. The simplest approach is to launch containers:

```bash
docker run --name stratum-postgres -e POSTGRES_USER=stratum -e POSTGRES_PASSWORD=stratum -e POSTGRES_DB=stratum -p 5432:5432 -d postgres:15

docker run --name stratum-artemis -e ARTEMIS_USER=stratum -e ARTEMIS_PASSWORD=stratum -p 61616:61616 -p 8161:8161 -d quay.io/artemiscloud/activemq-artemis-broker:artemis.2.31.2

docker run --name stratum-keycloak -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8080:8080 -d quay.io/keycloak/keycloak:24.0.3 start-dev
```

The backend ships with sensible defaults that point to these container ports. Adjust according to your environment.

## 6. Run the Backend (Choose One)

### Option A — Embedded Liberty via Docker

```bash
cd deploy/liberty
docker build -t stratum-liberty .
docker run --rm -p 9080:9080 -p 9443:9443 \
  -e STRATUM_DB_URL -e STRATUM_DB_USER -e STRATUM_DB_PASSWORD \
  --name stratum-liberty stratum-liberty
```

This image copies the WAR artifacts produced in step 4 into the Liberty server and exposes HTTP on port 9080.

### Option B — Host Liberty Installation

```bash
cd deploy/liberty
./run-local-liberty.sh
```

The script builds the backend, then invokes `${LIBERTY_HOME}/bin/server run defaultServer`. Use the accompanying `.cmd` script on Windows.

### Option C — Thin Boot Runner (Experimental)

The repository includes profiles for building a thin-boot runnable JAR. To try it:

```bash
mvn -P liberty,thin-boot package
java -jar backend/apps/api-gateway/target/stratum-api-gateway-thin.jar
```

## 7. Seed Demo Content

With the backend running, POST the provided demo artifacts using the Admin Console API or copy the YAML/XSLT files into your configured repository volume. Example:

```bash
curl -X POST http://localhost:9080/admin/api/flows \
  -H "Content-Type: application/yaml" \
  --data-binary @seed/flows/pacs008_inbound.yml
```

Additional assets live under `seed/`.

## 8. Launch the Web Console

```bash
cd frontend/web-console
npm install
npm run dev
```

The dev server starts on [http://localhost:5173](http://localhost:5173) with hot module reload. It proxies backend calls to the Liberty instance on port 9080 by default; adjust the Vite proxy configuration in `vite.config.ts` if needed.

## 9. Verify Everything Works

1. Visit `http://localhost:5173` and sign in with the seeded Keycloak user (`admin` / `admin`).
2. Navigate to **Workspaces → Demo** and import the sample flows.
3. Run the MT103 → pacs.008 demo by dropping `seed/data/sample_mt103.txt` into the configured inbound directory.
4. Monitor results under **Operations → Lineage** and **Analytics**.

## 10. Stop Services

When finished, stop the containers and Liberty server:

```bash
docker stop stratum-postgres stratum-artemis stratum-keycloak stratum-liberty
```

If you used the host-run script, interrupt it with `Ctrl+C`.

---

For troubleshooting tips, advanced profiles (WildFly/Payara), and deployment guidance, consult the documents under `docs/`.
