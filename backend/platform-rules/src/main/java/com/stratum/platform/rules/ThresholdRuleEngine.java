package com.stratum.platform.rules;

import java.math.BigDecimal;
import java.util.Map;

import com.stratum.platform.core.Payment;

/**
 * Minimal rule engine evaluating amount thresholds from YAML configuration.
 */
public class ThresholdRuleEngine {

    private final Map<String, BigDecimal> thresholds;

    public ThresholdRuleEngine(Map<String, BigDecimal> thresholds) {
        this.thresholds = thresholds;
    }

    public boolean exceedsThreshold(Payment payment) {
        BigDecimal limit = thresholds.getOrDefault(payment.getCurrency(), BigDecimal.ZERO);
        return payment.getInstructedAmount().compareTo(limit) > 0;
    }
}
