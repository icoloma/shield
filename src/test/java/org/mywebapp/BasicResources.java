package org.mywebapp;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Test classes to use
 */
@Path("/basic")
public class BasicResources {

    @GET
    public Response getAll() {
        return Response.ok().build();
    }

    @PUT
    public Response put() {
        return Response.ok().build();
    }

    @GET @Path("{id}")
    public Response get(@QueryParam("id") int id) {
        return Response.ok().build();
    }


    @POST @Path("{id}")
    public Response post(@FormParam("id") int id) {
        return Response.ok().build();
    }

}
