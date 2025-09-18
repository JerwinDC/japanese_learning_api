package com.learning.japanese.Dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddQuestionRequest {
    @NotNull(message = "test id is required!")
    private Integer testId;

    @NotBlank(message = "question is required!")
    private String question;

    @NotNull(message = "type is required!")
    private TestType type;
}
