package com.learning.japanese.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddBookRequest {
    @NotBlank(message = "title is required")
    private String title;
}
