package com.learning.japanese.Dtos;

import lombok.Data;

@Data
public class AddQuestionResponse {
    private int id;
    private String question;
    private TestType type;
}
