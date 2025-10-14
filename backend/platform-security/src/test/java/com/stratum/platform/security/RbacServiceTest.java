package com.stratum.platform.security;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class RbacServiceTest {

    @Test
    void validatesPermission() {
        RbacService service = new RbacService(Map.of("admin", Set.of("flows:write")));
        assertTrue(service.isAllowed("admin", "flows:write"));
    }
}
