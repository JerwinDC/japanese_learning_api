package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.TestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<TestQuestion, Integer> {
}
