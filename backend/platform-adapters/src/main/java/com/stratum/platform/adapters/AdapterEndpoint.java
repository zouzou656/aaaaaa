package com.stratum.platform.adapters;

import com.stratum.platform.core.Payment;

/**
 * Contract for transport adapters to exchange canonical payments with external systems.
 */
public interface AdapterEndpoint {

    String name();

    void send(Payment payment);
}
