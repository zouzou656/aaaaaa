package com.stratum.platform.dsl;

import java.util.List;
import java.util.Map;

/**
 * Representation of a parsed flow DSL.
 */
public record FlowDefinition(
        String name,
        String version,
        Map<String, Object> receive,
        List<Map<String, Object>> steps,
        Map<String, Object> retryPolicy) {
}
