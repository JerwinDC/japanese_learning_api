package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.LessonResponseDto;
import com.learning.japanese.Entities.Lesson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    LessonResponseDto toDto(Lesson lesson);

}
