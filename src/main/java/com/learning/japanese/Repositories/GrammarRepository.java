package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.Grammar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrammarRepository extends JpaRepository<Grammar, Integer> {
}
