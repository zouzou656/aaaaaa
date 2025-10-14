package com.stratum.platform.dsl;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

/**
 * Parses YAML flow definitions into immutable records.
 */
public class FlowParser {

    private final Yaml yaml = new Yaml();

    @SuppressWarnings("unchecked")
    public FlowDefinition parse(InputStream yamlStream) {
        Map<String, Object> data = yaml.load(yamlStream);
        String name = (String) data.get("flow");
        String version = (String) data.getOrDefault("version", "1.0");
        Map<String, Object> receive = (Map<String, Object>) data.get("receive");
        List<Map<String, Object>> steps = (List<Map<String, Object>>) data.getOrDefault("steps", List.of());
        Map<String, Object> retryPolicy = (Map<String, Object>) data.getOrDefault("retries", Map.of());
        return new FlowDefinition(name, version, receive, steps, retryPolicy);
    }
}
