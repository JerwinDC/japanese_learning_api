package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
