package com.stratum.apps.workerindexer;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

import com.stratum.platform.audit.AuditTrailService;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/stratum.audit"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class IndexerBean implements MessageListener {

    @Inject
    AuditTrailService auditTrailService;

    @Override
    public void onMessage(Message message) {
        if (auditTrailService != null) {
            auditTrailService.events();
        }
    }
}
