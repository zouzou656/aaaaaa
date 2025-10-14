package com.stratum.server.spi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class ServerProfileContributorTest {

    @Test
    void writesConfiguration() throws Exception {
        ServerProfileContributor contributor = new ServerProfileContributor() {
            @Override
            public String serverId() {
                return "demo";
            }

            @Override
            public void writeConfiguration(Path directory) throws Exception {
                Files.createDirectories(directory);
                Files.writeString(directory.resolve("config.txt"), "demo");
            }
        };
        Path temp = Files.createTempDirectory("contrib");
        contributor.writeConfiguration(temp);
        assertEquals("demo", contributor.serverId());
    }
}
