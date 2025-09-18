package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.Test;
import com.learning.japanese.Entities.TestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestQuestionRepository extends JpaRepository<TestQuestion, Integer> {
}
