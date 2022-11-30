package com.example.test.resources;

import com.example.test.entities.Book;
import com.example.test.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/book")
public class BookResource {

  private final BookService bookService;

  @Autowired
  public BookResource(BookService bookService) {
    this.bookService = bookService;
  }

  @POST
  @Path("/save")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response save(Book book) {
    return Response.status(Response.Status.OK).entity(bookService.save(book)).build();
  }

  @DELETE
  @Path("/delete")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response delete(Book book) {
    bookService.delete(book);
    return Response.status(Response.Status.OK).build();
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
