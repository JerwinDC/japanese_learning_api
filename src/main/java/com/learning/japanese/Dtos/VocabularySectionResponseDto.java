package com.learning.japanese.Dtos;

import lombok.Data;

@Data
public class VocabularySectionResponseDto {
    private int id;
    private String jp;
    private String romaji;
    private String en;
}
