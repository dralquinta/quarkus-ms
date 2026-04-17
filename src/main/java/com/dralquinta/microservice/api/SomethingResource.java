package com.dralquinta.microservice.api;

import com.dralquinta.microservice.service.SomethingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/v1/something")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Something")
public class SomethingResource {

    private final SomethingService somethingService;

    @Inject
    public SomethingResource(SomethingService somethingService) {
        this.somethingService = somethingService;
    }

    @GET
    @Operation(summary = "get-something")
    public SomethingResponse getSomething() {
        return somethingService.getSomething();
    }
}
