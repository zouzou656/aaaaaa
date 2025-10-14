package com.stratum.server.liberty;

import java.nio.file.Files;
import java.nio.file.Path;

import com.stratum.server.spi.ServerProfileContributor;

public class LibertyProfileContributor implements ServerProfileContributor {

    @Override
    public String serverId() {
        return "liberty";
    }

    @Override
    public void writeConfiguration(Path directory) throws Exception {
        Files.createDirectories(directory);
        Files.writeString(directory.resolve("server.xml"), "<!-- liberty configuration stub -->");
    }
}
