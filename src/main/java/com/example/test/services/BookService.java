package com.example.test.services;

import com.example.test.entities.Book;
import com.example.test.repositories.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public Book save(Book book) {
    return bookRepository.save(book);
  }

  public void delete(Long id) {
    bookRepository.deleteById(id);

  }

  public List<Book> getAllByAuthorId(Long id) {
    return bookRepository.findAllByAuthorId(id);
  }

}

