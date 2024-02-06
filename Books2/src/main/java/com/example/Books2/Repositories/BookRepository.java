package com.example.Books2.Repositories;

import com.example.Books2.Models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, String> {

    Optional<Books> findAuthorById(String s);

    Optional<List<Books>> findBooksByAuthor(String s);
}
