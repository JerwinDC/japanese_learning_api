package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.VocabularySectionResponseDto;
import com.learning.japanese.Entities.Vocabulary;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VocabularyMapper {

    VocabularySectionResponseDto toDto(Vocabulary vocabulary);

}
