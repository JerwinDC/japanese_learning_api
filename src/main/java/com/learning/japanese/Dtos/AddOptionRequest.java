package com.learning.japanese.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddOptionRequest {
    @NotNull(message = "question id is required!")
    private Integer questionId;

    @NotBlank(message = "option is required!")
    private String optionText;

    @NotNull(message = "boolean is required!")
    private Boolean isCorrect;
}
