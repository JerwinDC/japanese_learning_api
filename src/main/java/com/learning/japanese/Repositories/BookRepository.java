package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.Book;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByTitle(String title);

    boolean existsByTitle(String title);
}
