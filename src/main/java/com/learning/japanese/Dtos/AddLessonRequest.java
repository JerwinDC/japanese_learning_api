package com.learning.japanese.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddLessonRequest {
    @NotNull(message = "Book Id is required")
    private Integer bookId;

    @NotBlank(message = "Title is required")
    private String title;


}
