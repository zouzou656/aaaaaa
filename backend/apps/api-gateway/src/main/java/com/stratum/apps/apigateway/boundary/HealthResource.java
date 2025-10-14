package com.stratum.apps.apigateway.boundary;

import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/healthz")
@ApplicationScoped
public class HealthResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> health() {
        return Map.of("status", "UP", "service", "stratum-api-gateway");
    }
}
