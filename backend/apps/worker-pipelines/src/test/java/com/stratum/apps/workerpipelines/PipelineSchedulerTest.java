package com.stratum.apps.workerpipelines;

import org.junit.jupiter.api.Test;

class PipelineSchedulerTest {

    @Test
    void executesWithoutResources() {
        PipelineScheduler scheduler = new PipelineScheduler();
        scheduler.fireCutoffCheck();
    }
}
