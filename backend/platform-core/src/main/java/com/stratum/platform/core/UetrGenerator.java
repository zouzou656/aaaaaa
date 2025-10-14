package com.stratum.platform.core;

import java.util.UUID;

/**
 * Generates SWIFT-compliant Unique End-to-end Transaction References.
 */
public final class UetrGenerator {

    private UetrGenerator() {
    }

    public static UUID newUetr() {
        return UUID.randomUUID();
    }
}
