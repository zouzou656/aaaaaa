package com.stratum.apps.workerrules;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.stratum.platform.rules.ThresholdRuleEngine;

class RulesResourceTest {

    @Test
    void respondsWithEvaluation() {
        RulesResource resource = new RulesResource();
        resource.engine = new ThresholdRuleEngine(Map.of("EUR", BigDecimal.ONE));
        Map<String, Object> result = resource.evaluate(Map.of("amount", "2", "currency", "EUR"));
        assertTrue((Boolean) result.get("exceedsThreshold"));
    }
}
