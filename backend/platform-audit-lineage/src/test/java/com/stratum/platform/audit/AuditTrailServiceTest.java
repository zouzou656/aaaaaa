package com.stratum.platform.audit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.junit.jupiter.api.Test;

import com.stratum.platform.core.Party;
import com.stratum.platform.core.Payment;

class AuditTrailServiceTest {

    @Test
    void recordsEvents() {
        AuditTrailService service = new AuditTrailService();
        Payment payment = new Payment(null, "AAAABBCC", "DDDDEEFF",
                new Party("Sender", "123"), new Party("Receiver", "456"),
                new BigDecimal("10.00"), "EUR", OffsetDateTime.now());
        service.record("ROUTE", payment);
        assertEquals(1, service.events().size());
    }
}
