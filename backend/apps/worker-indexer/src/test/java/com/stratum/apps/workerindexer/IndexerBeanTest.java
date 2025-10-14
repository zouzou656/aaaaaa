package com.stratum.apps.workerindexer;

import jakarta.jms.Destination;
import jakarta.jms.ExceptionListener;
import jakarta.jms.JMSException;
import jakarta.jms.Message;

import org.junit.jupiter.api.Test;

class IndexerBeanTest {

    @Test
    void handlesMessageWithoutServices() {
        IndexerBean bean = new IndexerBean();
        bean.onMessage(new NoopMessage());
    }

    private static class NoopMessage implements Message {

        @Override
        public String getJMSMessageID() {
            return null;
        }

        @Override
        public void setJMSMessageID(String id) {
        }

        @Override
        public long getJMSTimestamp() {
            return 0;
        }

        @Override
        public void setJMSTimestamp(long timestamp) {
        }

        @Override
        public byte[] getJMSCorrelationIDAsBytes() {
            return new byte[0];
        }

        @Override
        public void setJMSCorrelationIDAsBytes(byte[] correlationID) {
        }

        @Override
        public void setJMSCorrelationID(String correlationID) {
        }

        @Override
        public String getJMSCorrelationID() {
            return null;
        }

        @Override
        public Destination getJMSReplyTo() {
            return null;
        }

        @Override
        public void setJMSReplyTo(Destination replyTo) {
        }

        @Override
        public Destination getJMSDestination() {
            return null;
        }

        @Override
        public void setJMSDestination(Destination destination) {
        }

        @Override
        public int getJMSDeliveryMode() {
            return 0;
        }

        @Override
        public void setJMSDeliveryMode(int deliveryMode) {
        }

        @Override
        public boolean getJMSRedelivered() {
            return false;
        }

        @Override
        public void setJMSRedelivered(boolean redelivered) {
        }

        @Override
        public String getJMSType() {
            return null;
        }

        @Override
        public void setJMSType(String type) {
        }

        @Override
        public long getJMSExpiration() {
            return 0;
        }

        @Override
        public void setJMSExpiration(long expiration) {
        }

        @Override
        public int getJMSPriority() {
            return 0;
        }

        @Override
        public void setJMSPriority(int priority) {
        }

        @Override
        public void clearProperties() {
        }

        @Override
        public boolean propertyExists(String name) {
            return false;
        }

        @Override
        public boolean getBooleanProperty(String name) {
            return false;
        }

        @Override
        public byte getByteProperty(String name) {
            return 0;
        }

        @Override
        public short getShortProperty(String name) {
            return 0;
        }

        @Override
        public int getIntProperty(String name) {
            return 0;
        }

        @Override
        public long getLongProperty(String name) {
            return 0;
        }

        @Override
        public float getFloatProperty(String name) {
            return 0;
        }

        @Override
        public double getDoubleProperty(String name) {
            return 0;
        }

        @Override
        public String getStringProperty(String name) {
            return null;
        }

        @Override
        public Object getObjectProperty(String name) {
            return null;
        }

        @Override
        public java.util.Enumeration<String> getPropertyNames() {
            return java.util.Collections.emptyEnumeration();
        }

        @Override
        public void setBooleanProperty(String name, boolean value) {
        }

        @Override
        public void setByteProperty(String name, byte value) {
        }

        @Override
        public void setShortProperty(String name, short value) {
        }

        @Override
        public void setIntProperty(String name, int value) {
        }

        @Override
        public void setLongProperty(String name, long value) {
        }

        @Override
        public void setFloatProperty(String name, float value) {
        }

        @Override
        public void setDoubleProperty(String name, double value) {
        }

        @Override
        public void setStringProperty(String name, String value) {
        }

        @Override
        public void setObjectProperty(String name, Object value) {
        }

        @Override
        public void acknowledge() {
        }

        @Override
        public void clearBody() {
        }

        @Override
        public <T> T getBody(Class<T> c) {
            return null;
        }

        @Override
        public boolean isBodyAssignableTo(Class c) {
            return false;
        }

        @Override
        public void setJMSDeliveryTime(long deliveryTime) {
        }

        @Override
        public long getJMSDeliveryTime() {
            return 0;
        }

        @Override
        public void setJMSReplyToName(String replyToName) {
        }

        @Override
        public String getJMSReplyToName() {
            return null;
        }

        @Override
        public void setJMSDestinationName(String destinationName) {
        }

        @Override
        public String getJMSDestinationName() {
            return null;
        }

        @Override
        public void setJMSExceptionListener(ExceptionListener listener) {
        }

        @Override
        public ExceptionListener getJMSExceptionListener() {
            return null;
        }

        @Override
        public void setJMSRedeliveryDelay(long redeliveryDelay) throws JMSException {
        }

        @Override
        public long getJMSRedeliveryDelay() throws JMSException {
            return 0;
        }
    }
}
