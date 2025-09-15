package com.learning.japanese.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddVocabularyRequest {
    @NotNull(message = "Book id is required")
    private int bookId;

    @NotNull(message = "lesson id is required")
    private int lessonId;

    @NotNull(message = "section id is required")
    private int sectionId;

    @NotBlank(message = "Japanese is required")
    private String jp;

    private String romaji;

    @NotBlank(message = "English is required")
    private String en;
}
