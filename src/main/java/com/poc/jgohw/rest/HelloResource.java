package com.poc.jgohw.rest;

import com.google.inject.Inject;
import com.poc.jgohw.dao.HelloDao;
import com.poc.jgohw.domain.Hello;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/hello")
public class HelloResource {

    private final HelloDao helloDAO;

    @Inject
    public HelloResource(HelloDao helloDAO) {
        this.helloDAO = helloDAO;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hello> fetch() {
        return helloDAO.getEntities();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hello getById(@PathParam("id") final Long id) {
        return helloDAO.getEntityById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveItem(Hello hello) {
        helloDAO.insertEntity(hello);
        return Response.created(URI.create(hello.getId().toString())).entity(hello).build();
    }
}
