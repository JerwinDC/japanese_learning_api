package com.learning.japanese.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddGrammarRequest {
    @NotNull(message = "section id is required")
    private Integer sectionId;

    @NotBlank(message = "content is required")
    private String content;

    @NotBlank(message = "formula is required")
    private String formula;
}
