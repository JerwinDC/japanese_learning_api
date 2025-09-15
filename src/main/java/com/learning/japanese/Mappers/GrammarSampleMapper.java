package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.GrammarSampleResponseDto;
import com.learning.japanese.Entities.GrammarSample;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrammarSampleMapper {

    GrammarSampleResponseDto toDto(GrammarSample grammarSample);

}
