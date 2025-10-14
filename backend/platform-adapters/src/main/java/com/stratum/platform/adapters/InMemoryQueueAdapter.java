package com.stratum.platform.adapters;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.stratum.platform.core.Payment;

/**
 * Simple adapter for tests and demos.
 */
public class InMemoryQueueAdapter implements AdapterEndpoint {

    private final Queue<Payment> queue = new ConcurrentLinkedQueue<>();
    private final String name;

    public InMemoryQueueAdapter(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void send(Payment payment) {
        queue.add(payment);
    }

    public Queue<Payment> queue() {
        return queue;
    }
}
