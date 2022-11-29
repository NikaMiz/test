package com.example.test.repositories;

import com.example.test.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author save(Author author);

    void delete(Author author);
}
