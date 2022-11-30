package com.example.test.entities;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "Id", nullable = false)
  private Long id;

  @Column(name = "ISBN", nullable = false, length = 13)
  private String isbn;

  @Column(name = "Title", nullable = false)
  private String title;

  @Column(name = "Year", nullable = false, length = 4)
  private String year;

  @Column(name = "Genre", nullable = false)
  private String genre;

  @Column(name = "Date", nullable = false)
  private LocalTime date;

//  @Column(name = "AuthorId", nullable = false)
//  private Long authorId;

  @ManyToOne
  @JoinColumn(name = "AuthorId", foreignKey = @ForeignKey(name = "FK_Authors_Books_id"))
  private Author author;

  public Book() {
  }

  public Book(String isbn, String title, String year, String genre) {
    this.isbn = isbn;
    this.title = title;
    this.year = year;
    this.genre = genre;
  }

  public Book(Long id, String isbn, String title, String year, String genre, LocalTime date, Author author) {
    this.id = id;
    this.isbn = isbn;
    this.title = title;
    this.year = year;
    this.genre = genre;
    this.date = date;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public LocalTime getDate() {
    return date;
  }

  public void setDate(LocalTime date) {
    this.date = date;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

}

