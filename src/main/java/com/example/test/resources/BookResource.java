package com.example.test.resources;

import com.example.test.services.BookService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/book")
public class BookResource {

  private final BookService bookService;

  public BookResource(BookService bookService) {
    this.bookService = bookService;
  }

  @GET
  @Path("/find/byAuthorId/{authorId}")
  public Response findAllByAuthorId(@PathParam("authorId") Long authorId) {
    return Response.status(Status.OK).entity(bookService.getAllByAuthorId(authorId)).build();
  }


  @GET
  @Path("/all")
  public String getAllBooks() {
    return "Все хорошо получилось!!!!!!!!!(книги)";
  }

  @POST
  public String postBooks() {
    return "Все хорошо получилось!!!!!!!!!(книги2.0)";
  }
}
