package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.GrammarSectionResponseDto;
import com.learning.japanese.Entities.Grammar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = GrammarSampleMapper.class)
public interface GrammarMapper {


    GrammarSectionResponseDto toDto(Grammar grammar);

}
