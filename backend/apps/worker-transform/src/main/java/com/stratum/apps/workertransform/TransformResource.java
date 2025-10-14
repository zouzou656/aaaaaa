package com.stratum.apps.workertransform;

import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import com.stratum.platform.transform.XsltTransformService;

@Path("/transform")
@ApplicationScoped
public class TransformResource {

    @Inject
    XsltTransformService xslt;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> transform(Map<String, Object> request) throws Exception {
        String stylesheet = (String) request.get("stylesheet");
        String payload = (String) request.get("payload");
        String result = xslt.transform(stylesheet, payload, Map.of());
        return Map.of("result", result);
    }
}
