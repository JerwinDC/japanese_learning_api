package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    Optional<Lesson> findLessonByTitle(String title);

}
