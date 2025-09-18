package com.learning.japanese.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddTestRequest {
    @NotNull(message = "lesson id is required!")
    private Integer lessonId;

    @NotBlank(message = "title is required!")
    private String title;

    @NotBlank(message = "description is required!")
    private String description;

}
