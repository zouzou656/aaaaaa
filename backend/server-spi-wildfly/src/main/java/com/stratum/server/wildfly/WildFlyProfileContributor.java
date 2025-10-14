package com.stratum.server.wildfly;

import java.nio.file.Files;
import java.nio.file.Path;

import com.stratum.server.spi.ServerProfileContributor;

public class WildFlyProfileContributor implements ServerProfileContributor {

    @Override
    public String serverId() {
        return "wildfly";
    }

    @Override
    public void writeConfiguration(Path directory) throws Exception {
        Files.createDirectories(directory);
        Files.writeString(directory.resolve("standalone-full.xml"), "<!-- wildfly configuration stub -->");
    }
}
