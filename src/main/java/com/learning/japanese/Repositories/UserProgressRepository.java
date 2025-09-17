package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProgressRepository extends JpaRepository<UserProgress, Integer> {
}
