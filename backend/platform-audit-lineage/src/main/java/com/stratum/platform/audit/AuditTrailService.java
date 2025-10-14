package com.stratum.platform.audit;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.stratum.platform.core.Payment;

/**
 * In-memory audit trail suitable for unit testing.
 */
public class AuditTrailService {

    private final List<String> events = Collections.synchronizedList(new ArrayList<>());

    public void record(String eventType, Payment payment) {
        String entry = "%s|%s|%s".formatted(eventType, payment.getUetr(), OffsetDateTime.now());
        events.add(entry);
    }

    public List<String> events() {
        return List.copyOf(events);
    }
}
