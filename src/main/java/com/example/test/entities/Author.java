package com.example.test.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Authors")
public class Author implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "Id", nullable = false)
  private Long id;

  @Column(name = "Surname", nullable = false)
  private String surname;

  @Column(name = "Name", nullable = false)
  private String name;

  @Column(name = "Patronymic")
  private String patronymic;

  @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Book> books = new ArrayList<>();

  public Author() {
  }

  public Author(Long id) {
    this.id = id;
  }

  public Author(String surname, String name, String patronymic) {
    this.surname = surname;
    this.name = name;
    this.patronymic = patronymic;
  }

  public Author(Long id, String surname, String name, String patronymic, List<Book> books) {
    this.id = id;
    this.surname = surname;
    this.name = name;
    this.patronymic = patronymic;
    this.books = books;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  @Override
  public String toString() {
    return "Author: " +
            "id = " + this.id +
            " surname = " + this.surname +
            " name = " + this.name +
            " patronymic = " + this.patronymic;
  }
}
