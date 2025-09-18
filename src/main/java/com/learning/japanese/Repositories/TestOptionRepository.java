package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.TestOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestOptionRepository extends JpaRepository<TestOption, Integer> {
}