package com.example.resource;

import com.example.model.Particle;
import com.example.service.SimulationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/simulation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SimulationResource {

    @Inject
    SimulationService simulationService;

    @GET
    @Path("/init")
    public List<Particle> initialize() {
        return simulationService.getParticles();
    }

    @GET
    public List<Particle> getParticles() {
        return simulationService.getParticles();
    }

    @GET
    @Path("/step")
    public List<Particle> step(@QueryParam("dt") @DefaultValue("1") double dt) {
        simulationService.step(dt);
        return simulationService.getParticles();
    }
}
