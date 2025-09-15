package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.GrammarSample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrammarSampleRepository extends JpaRepository<GrammarSample, Integer> {
}
