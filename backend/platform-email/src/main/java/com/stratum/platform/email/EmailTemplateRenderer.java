package com.stratum.platform.email;

import java.util.Map;

/**
 * Very small Handlebars-like renderer using String templates.
 */
public class EmailTemplateRenderer {

    public String render(String template, Map<String, Object> variables) {
        String result = template;
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            result = result.replace("{{" + entry.getKey() + "}}", String.valueOf(entry.getValue()));
        }
        return result;
    }
}
