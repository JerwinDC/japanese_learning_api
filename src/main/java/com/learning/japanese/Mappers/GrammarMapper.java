package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.GrammarSectionResponseDto;
import com.learning.japanese.Entities.Grammar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrammarMapper {

    GrammarSectionResponseDto toDto(Grammar grammar);

}
