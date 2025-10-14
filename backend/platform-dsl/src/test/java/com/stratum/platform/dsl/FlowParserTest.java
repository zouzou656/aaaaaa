package com.stratum.platform.dsl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class FlowParserTest {

    @Test
    void parsesBasicFlow() {
        String yaml = "flow: demo\n" +
                "version: 1.0\n" +
                "receive:\n  adapter: file\n" +
                "steps:\n  - validate: true\n";
        FlowParser parser = new FlowParser();
        FlowDefinition definition = parser.parse(new ByteArrayInputStream(yaml.getBytes(StandardCharsets.UTF_8)));
        assertEquals("demo", definition.name());
        assertNotNull(definition.receive());
    }
}
