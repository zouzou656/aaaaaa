package com.stratum.platform.email;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

class EmailTemplateRendererTest {

    @Test
    void rendersVariables() {
        EmailTemplateRenderer renderer = new EmailTemplateRenderer();
        String result = renderer.render("Hello {{name}}", Map.of("name", "Stratum"));
        assertEquals("Hello Stratum", result);
    }
}
