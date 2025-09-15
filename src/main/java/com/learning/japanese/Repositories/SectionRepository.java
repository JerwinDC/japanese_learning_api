package com.learning.japanese.Repositories;

import com.learning.japanese.Entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Integer> {
}
