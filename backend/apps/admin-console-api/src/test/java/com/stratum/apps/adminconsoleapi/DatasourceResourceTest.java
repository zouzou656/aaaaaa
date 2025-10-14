package com.stratum.apps.adminconsoleapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DatasourceResourceTest {

    @Test
    void storesDatasource() {
        DatasourceResource resource = new DatasourceResource();
        resource.create(new DatasourceResource.DatasourceRequest("jdbc/PlatOps", true, "jdbc:postgresql://localhost/demo"));
        assertEquals(1, resource.list().size());
    }
}
