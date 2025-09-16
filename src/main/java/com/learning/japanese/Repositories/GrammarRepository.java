package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.Grammar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GrammarRepository extends JpaRepository<Grammar, Integer> {

    @Query("SELECT g FROM Grammar g LEFT JOIN FETCH g.samples WHERE g.id = :id")
    Optional<Grammar> findByIdWithSamples(@Param("id") int id);
}
