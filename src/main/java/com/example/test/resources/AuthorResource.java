package com.example.test.resources;

import com.example.test.entities.Author;
import com.example.test.services.AuthorService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/author")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {

    private final AuthorService authorService;

    @Autowired
    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    @POST
    @Path("/save")
    public Response save(Author author) {
        return Response.status(Response.Status.OK).entity(authorService.save(author)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        authorService.delete(id);
        return Response.ok().build();
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
