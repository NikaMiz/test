package com.example.test.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/author")
public class AuthorResource {

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
