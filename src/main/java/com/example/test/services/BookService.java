package com.example.test.services;

import com.example.test.repositories.BookRepository;
import java.awt.print.Book;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getAllByAuthorId(Long id) {
    return bookRepository.findAllByAuthorId(id);
  }

}

