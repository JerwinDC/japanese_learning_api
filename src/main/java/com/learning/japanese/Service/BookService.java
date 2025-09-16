package com.learning.japanese.Service;

import com.learning.japanese.Dtos.*;
import com.learning.japanese.Entities.Grammar;
import com.learning.japanese.Exceptions.BookNotFoundException;
import com.learning.japanese.Exceptions.LessonNotFoundException;
import com.learning.japanese.Exceptions.SectionNotFoundException;
import com.learning.japanese.Exceptions.VocabularyNotFoundException;
import com.learning.japanese.Mappers.*;
import com.learning.japanese.Repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final LessonRepository lessonRepository;
    private final SectionRepository sectionRepository;
    private final GrammarRepository grammarRepository;
    private final VocabularyRepository vocabularyRepository;
    private final GrammarSampleRepository grammarSampleRepository;
    private final BookMapper bookMapper;
    private final LessonMapper lessonMapper;
    private final SectionMapper sectionMapper;
    private final GrammarMapper grammarMapper;
    private final VocabularyMapper vocabularyMapper;
    private final GrammarSampleMapper grammarSampleMapper;

    public BookResponseDto getBook(int id){
        var book = bookRepository.findById(id).orElse(null);
        if(book == null){
            throw new BookNotFoundException();
        }

        return bookMapper.toDto(book);
    }

    public LessonResponseDto getLesson(int lessonId){
       var lesson = lessonRepository.findById(lessonId)
                .orElseThrow(LessonNotFoundException::new);

       return lessonMapper.toDto(lesson);

    }

    public SectionResponseDto getSection(int sectionId){
        var section = sectionRepository.findById(sectionId)
                .orElseThrow(SectionNotFoundException::new);

        return sectionMapper.toDto(section);

    }

    public VocabularySectionResponseDto getVocab(int vocabularyId){
        var vocab = vocabularyRepository.findById(vocabularyId)
                .orElseThrow(VocabularyNotFoundException::new);

        return vocabularyMapper.toDto(vocab);

    }

    public GrammarSectionResponseDto getGrammar(int grammarId){
        var grammar = grammarRepository.findByIdWithSamples(grammarId)
                .orElseThrow(VocabularyNotFoundException::new);

        return grammarMapper.toDto(grammar);


    }

    public GrammarSampleResponseDto getGrammarSample(int grammarSampleId){
        var grammarSample = grammarSampleRepository.findById(grammarSampleId)
                .orElseThrow(VocabularyNotFoundException::new);

        return grammarSampleMapper.toDto(grammarSample);

    }
}
