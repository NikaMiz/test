package com.example.test.resources;

import com.example.test.entities.Book;
import com.example.test.services.BookService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/book")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  private final BookService bookService;

  @Autowired
  public BookResource(BookService bookService) {
    this.bookService = bookService;
  }

  @POST
  @Path("/save")
  public Response save(Book book) {
    return Response.status(Response.Status.OK).entity(bookService.save(book)).build();
  }

  @DELETE
  @Path("/delete/{id}")
  public Response delete(@PathParam("id") Long id) {
    bookService.delete(id);
    return Response.ok().build();
  }

  @GET
  @Path("/find/byAuthorId/{authorId}")
  public Response findAllByAuthorId(@PathParam("authorId") Long authorId) {
    return Response.status(Status.OK).entity(bookService.getAllByAuthorId(authorId)).build();
  }

  @GET
  @Path("/find/byTitle")
  public Response findBookByTitle(@QueryParam("title") String title){
    return Response.ok().entity(bookService.findBookByTitle(title)).build();
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
