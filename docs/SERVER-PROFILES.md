# Server Profiles

Stratum supports Open Liberty by default, with WildFly and Payara profiles available via Maven.

- Activate Liberty: `mvn -P liberty package`
- Activate WildFly: `mvn -P wildfly package`

Configuration fragments are generated through the server SPI modules.
