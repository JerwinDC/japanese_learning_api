package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.AddQuestionResponse;
import com.learning.japanese.Entities.TestQuestion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    AddQuestionResponse toDto(TestQuestion question);
}
