package com.stratum.server.spi;

import java.nio.file.Path;

/**
 * Allows modules to contribute server-specific configuration fragments.
 */
public interface ServerProfileContributor {

    String serverId();

    void writeConfiguration(Path directory) throws Exception;
}
