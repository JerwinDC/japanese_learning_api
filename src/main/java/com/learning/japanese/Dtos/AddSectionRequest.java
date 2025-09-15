package com.learning.japanese.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddSectionRequest {
    @NotNull(message = "Book id is required")
    private int bookId;

    @NotNull(message = "Lesson id is required")
    private int lessonId;

    @NotBlank(message = "Type is required!")
    private String type;

    @NotBlank(message = "Type is required!")
    private String title;
}
