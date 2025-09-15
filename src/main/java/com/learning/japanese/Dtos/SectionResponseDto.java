package com.learning.japanese.Dtos;

import lombok.Data;

import java.util.Set;

@Data
public class SectionResponseDto {
    private int id;
    private String type;
    private String title;
    private Set<VocabularySectionResponseDto> vocabularies;
    private Set<GrammarSectionResponseDto> grammars;
}
