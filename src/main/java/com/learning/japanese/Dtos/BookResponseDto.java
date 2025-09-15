package com.learning.japanese.Dtos;

import com.learning.japanese.Entities.Lesson;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class BookResponseDto {
    private int id;
    private String title;
    private Set<LessonResponseDto> lessons;
}
