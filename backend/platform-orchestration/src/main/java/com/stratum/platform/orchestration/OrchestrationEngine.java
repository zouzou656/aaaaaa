package com.stratum.platform.orchestration;

import java.util.Map;
import java.util.Objects;

import com.stratum.platform.adapters.AdapterEndpoint;
import com.stratum.platform.core.Payment;
import com.stratum.platform.dsl.FlowDefinition;
import com.stratum.platform.rules.ThresholdRuleEngine;

/**
 * Simplified orchestration engine executing flow steps sequentially.
 */
public class OrchestrationEngine {

    private final ThresholdRuleEngine ruleEngine;

    public OrchestrationEngine(ThresholdRuleEngine ruleEngine) {
        this.ruleEngine = Objects.requireNonNull(ruleEngine);
    }

    public void execute(FlowDefinition definition, Payment payment, Map<String, AdapterEndpoint> adapters) {
        boolean highValue = ruleEngine.exceedsThreshold(payment);
        for (Map<String, Object> step : definition.steps()) {
            Object route = step.get("route");
            if (route instanceof String targetName) {
                AdapterEndpoint endpoint = adapters.get(targetName);
                if (endpoint != null) {
                    endpoint.send(payment);
                }
            }
            if (highValue) {
                AdapterEndpoint audit = adapters.get("audit");
                if (audit != null) {
                    audit.send(payment);
                }
            }
        }
    }
}
