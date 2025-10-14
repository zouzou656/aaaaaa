package com.stratum.server.payara;

import java.nio.file.Files;
import java.nio.file.Path;

import com.stratum.server.spi.ServerProfileContributor;

public class PayaraProfileContributor implements ServerProfileContributor {

    @Override
    public String serverId() {
        return "payara";
    }

    @Override
    public void writeConfiguration(Path directory) throws Exception {
        Files.createDirectories(directory);
        Files.writeString(directory.resolve("domain.xml"), "<!-- payara configuration stub -->");
    }
}
