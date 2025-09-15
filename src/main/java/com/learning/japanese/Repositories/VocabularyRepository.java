package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {
}
