package com.stratum.apps.workerpipelines;

import java.time.OffsetDateTime;
import java.util.logging.Logger;

import jakarta.annotation.Resource;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

import com.stratum.platform.orchestration.OrchestrationEngine;

@Singleton
@Startup
public class PipelineScheduler {

    private static final Logger LOGGER = Logger.getLogger(PipelineScheduler.class.getName());

    @Inject
    OrchestrationEngine orchestrationEngine;

    @Resource(lookup = "java:/jms/queue/stratum.cutoff")
    Queue cutoffQueue;

    @Inject
    JMSContext context;

    @Schedule(hour = "*", minute = "*/5", persistent = false)
    public void fireCutoffCheck() {
        LOGGER.info(() -> "Dispatching cutoff check at " + OffsetDateTime.now());
        if (cutoffQueue != null && context != null) {
            context.createProducer().send(cutoffQueue, "CUT_OFF_CHECK");
        }
    }
}
