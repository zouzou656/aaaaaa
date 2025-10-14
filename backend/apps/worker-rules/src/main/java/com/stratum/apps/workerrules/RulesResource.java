package com.stratum.apps.workerrules;

import java.math.BigDecimal;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import com.stratum.platform.core.Party;
import com.stratum.platform.core.Payment;
import com.stratum.platform.rules.ThresholdRuleEngine;

@Path("/rules")
@ApplicationScoped
public class RulesResource {

    @Inject
    ThresholdRuleEngine engine;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> evaluate(Map<String, Object> request) {
        Payment payment = new Payment(null,
                (String) request.getOrDefault("debtorBic", "UNKNOWN"),
                (String) request.getOrDefault("creditorBic", "UNKNOWN"),
                new Party("debtor", "1"), new Party("creditor", "2"),
                new BigDecimal(request.getOrDefault("amount", "0").toString()),
                (String) request.getOrDefault("currency", "EUR"), null);
        boolean exceeds = engine.exceedsThreshold(payment);
        return Map.of("exceedsThreshold", exceeds);
    }
}
