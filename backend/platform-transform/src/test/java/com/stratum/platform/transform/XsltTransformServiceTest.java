package com.stratum.platform.transform;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

class XsltTransformServiceTest {

    @Test
    void appliesSimpleStylesheet() throws Exception {
        String xslt = "<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='3.0'>"
                + "<xsl:template match='/'>"
                + "<result><xsl:value-of select='/root/value'/></result>"
                + "</xsl:template></xsl:stylesheet>";
        String xml = "<root><value>demo</value></root>";
        XsltTransformService service = new XsltTransformService();
        String result = service.transform(xslt, xml, Map.of());
        assertTrue(result.contains("demo"));
    }
}
