package com.stratum.apps.adminconsoleapi;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/datasources")
@ApplicationScoped
public class DatasourceResource {

    private final List<DatasourceRequest> datasources = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DatasourceRequest> list() {
        return List.copyOf(datasources);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(DatasourceRequest request) {
        datasources.add(request);
    }

    public record DatasourceRequest(String name, boolean xa, String jdbcUrl) {
    }
}
