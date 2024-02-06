package com.example.Books2.Repositories;

import com.example.Books2.Models.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Authors, String> {

    Optional<Authors> findAuthorById(String s);
}
