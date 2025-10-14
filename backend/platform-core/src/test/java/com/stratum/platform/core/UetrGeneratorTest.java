package com.stratum.platform.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class UetrGeneratorTest {

    @Test
    void generatesUniqueReference() {
        UUID uetr = UetrGenerator.newUetr();
        assertNotNull(uetr, "UETR must be generated");
    }
}
