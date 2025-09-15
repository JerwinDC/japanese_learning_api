package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.BookResponseDto;
import com.learning.japanese.Entities.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = LessonMapper.class)
public interface BookMapper {

    BookResponseDto toDto(Book book);

}
