package com.stratum.apps.workertransform;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.stratum.platform.transform.XsltTransformService;

class TransformResourceTest {

    @Test
    void transformsPayload() throws Exception {
        TransformResource resource = new TransformResource();
        resource.xslt = new XsltTransformService();
        Map<String, Object> response = resource.transform(Map.of(
                "stylesheet", "<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='3.0'><xsl:template match='/'><result>ok</result></xsl:template></xsl:stylesheet>",
                "payload", "<root/>"));
        assertTrue(response.get("result").toString().contains("ok"));
    }
}
