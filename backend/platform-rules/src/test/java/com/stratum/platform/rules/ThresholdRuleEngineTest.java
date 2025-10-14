package com.stratum.platform.rules;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.stratum.platform.core.Party;
import com.stratum.platform.core.Payment;

class ThresholdRuleEngineTest {

    @Test
    void flagsPaymentsAboveThreshold() {
        ThresholdRuleEngine engine = new ThresholdRuleEngine(Map.of("EUR", new BigDecimal("100.00")));
        Payment payment = new Payment(null, "AAAABBCC", "DDDDEEFF",
                new Party("Sender", "123"), new Party("Receiver", "456"),
                new BigDecimal("200.00"), "EUR", OffsetDateTime.now());
        assertTrue(engine.exceedsThreshold(payment));
    }
}
