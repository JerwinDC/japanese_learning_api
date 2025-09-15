package com.learning.japanese.Dtos;

import lombok.Data;

import java.util.Set;

@Data
public class GrammarSectionResponseDto {
    private int id;
    private String content;
    private String formula;
    private Set<GrammarSampleResponseDto> samples;
}
