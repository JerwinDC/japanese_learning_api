package com.learning.japanese.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddGrammarSampleRequest {
    @NotNull(message = "grammar id is required")
    private Integer grammarId;

    @NotBlank(message = "jp is required")
    private String jp;

    @NotBlank(message = "en is required")
    private String en;
}
