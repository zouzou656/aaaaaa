package com.stratum.apps.apigateway.boundary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class HealthResourceTest {

    @Test
    void returnsUpStatus() {
        HealthResource resource = new HealthResource();
        Map<String, Object> response = resource.health();
        assertEquals("UP", response.get("status"));
    }
}
