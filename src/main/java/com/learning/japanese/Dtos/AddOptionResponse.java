package com.learning.japanese.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddOptionResponse {
    private int id;
    private String optionText;
    @JsonProperty("isCorrect")
    private boolean correct;
}
