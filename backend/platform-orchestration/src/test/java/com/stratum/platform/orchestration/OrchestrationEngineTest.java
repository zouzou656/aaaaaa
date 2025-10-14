package com.stratum.platform.orchestration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.stratum.platform.adapters.InMemoryQueueAdapter;
import com.stratum.platform.core.Party;
import com.stratum.platform.core.Payment;
import com.stratum.platform.dsl.FlowDefinition;
import com.stratum.platform.rules.ThresholdRuleEngine;

class OrchestrationEngineTest {

    @Test
    void routesToConfiguredAdapter() {
        ThresholdRuleEngine ruleEngine = new ThresholdRuleEngine(Map.of("EUR", new BigDecimal("1.00")));
        OrchestrationEngine engine = new OrchestrationEngine(ruleEngine);
        FlowDefinition definition = new FlowDefinition("demo", "1.0", Map.of(),
                List.of(Map.of("route", "primary")), Map.of());
        InMemoryQueueAdapter adapter = new InMemoryQueueAdapter("primary");
        InMemoryQueueAdapter audit = new InMemoryQueueAdapter("audit");
        Payment payment = new Payment(null, "AAAABBCC", "DDDDEEFF",
                new Party("Sender", "123"), new Party("Receiver", "456"),
                new BigDecimal("10.00"), "EUR", OffsetDateTime.now());
        engine.execute(definition, payment, Map.of("primary", adapter, "audit", audit));
        assertEquals(1, adapter.queue().size());
    }
}
