package com.learning.japanese.Service;

import com.learning.japanese.Dtos.BookResponseDto;
import com.learning.japanese.Dtos.LessonResponseDto;
import com.learning.japanese.Dtos.SectionResponseDto;
import com.learning.japanese.Exceptions.BookNotFoundException;
import com.learning.japanese.Exceptions.LessonNotFoundException;
import com.learning.japanese.Exceptions.SectionNotFoundException;
import com.learning.japanese.Mappers.BookMapper;
import com.learning.japanese.Mappers.LessonMapper;
import com.learning.japanese.Mappers.SectionMapper;
import com.learning.japanese.Repositories.BookRepository;
import com.learning.japanese.Repositories.LessonRepository;
import com.learning.japanese.Repositories.SectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final LessonRepository lessonRepository;
    private final SectionRepository sectionRepository;
    private final BookMapper bookMapper;
    private final LessonMapper lessonMapper;
    private final SectionMapper sectionMapper;

    public BookResponseDto getBook(int id){
        var book = bookRepository.findById(id).orElse(null);
        if(book == null){
            throw new BookNotFoundException();
        }

        return bookMapper.toDto(book);
    }

    public LessonResponseDto getLesson(int bookId, int lessonId){
       bookRepository.findById(bookId)
                .orElseThrow(BookNotFoundException::new);

       var lesson = lessonRepository.findById(lessonId)
                .orElseThrow(LessonNotFoundException::new);

       return lessonMapper.toDto(lesson);

    }

    public SectionResponseDto getSection(int bookId, int lessonId, int sectionId){
        bookRepository.findById(bookId)
                .orElseThrow(BookNotFoundException::new);

        lessonRepository.findById(lessonId)
                .orElseThrow(LessonNotFoundException::new);

        var section = sectionRepository.findById(sectionId)
                .orElseThrow(SectionNotFoundException::new);

        return sectionMapper.toDto(section);

    }
}
