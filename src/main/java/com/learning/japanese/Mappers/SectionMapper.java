package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.SectionResponseDto;
import com.learning.japanese.Entities.Section;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SectionMapper {

    SectionResponseDto toDto(Section section);

}
