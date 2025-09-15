package com.learning.japanese.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddGrammarSampleRequest {
    @NotNull(message = "Book id is required")
    private int bookId;

    @NotNull(message = "lesson id is required")
    private int lessonId;

    @NotNull(message = "section id is required")
    private int sectionId;

    @NotNull(message = "grammar id is required")
    private int grammarId;

    @NotBlank(message = "jp is required")
    private String jp;

    @NotBlank(message = "en is required")
    private String en;
}
