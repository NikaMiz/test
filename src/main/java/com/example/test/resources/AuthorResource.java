package com.example.test.resources;

import com.example.test.entities.Author;
import com.example.test.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/author")
public class AuthorResource {

    private final AuthorService authorService;

    @Autowired
    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Author author) {
        return Response.status(Response.Status.OK).entity(authorService.save(author)).build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Author author) {
        authorService.delete(author);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/all")
    public String getAllAuthors() {
        return "Все хорошо получилось!!!!!!!!!(авторы)";
    }

    @POST
    public String postAuthors() {
        return "Все хорошо получилось!!!!!!!!!(авторы2.0)";
    }
}
