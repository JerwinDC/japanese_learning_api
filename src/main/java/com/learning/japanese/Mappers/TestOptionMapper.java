package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.AddOptionResponse;
import com.learning.japanese.Entities.TestOption;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestOptionMapper {

    @Mapping(source = "optionText", target = "optionText")
    @Mapping(source = "isCorrect", target = "correct")
    AddOptionResponse toDto(TestOption option);

}
