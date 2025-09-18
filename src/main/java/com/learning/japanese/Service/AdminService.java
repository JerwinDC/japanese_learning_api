package com.learning.japanese.Service;

import com.learning.japanese.Dtos.*;
import com.learning.japanese.Entities.*;
import com.learning.japanese.Exceptions.*;
import com.learning.japanese.Mappers.*;
import com.learning.japanese.Repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class AdminService {
    private final BookRepository bookRepository;
    private final TestRepository testRepository;
    private final LessonRepository lessonRepository;
    private final GrammarRepository grammarRepository;
    private final SectionRepository sectionRepository;
    private final QuestionRepository questionRepository;
    private final VocabularyRepository vocabularyRepository;
    private final TestQuestionRepository testQuestionRepository;
    private final GrammarSampleRepository grammarSampleRepository;
    private final TestMapper testMapper;
    private final LessonMapper lessonMapper;
    private final SectionMapper sectionMapper;
    private final GrammarMapper grammarMapper;
    private final QuestionMapper questionMapper;
    private final VocabularyMapper vocabularyMapper;
    private final TestOptionMapper testOptionMapper;
    private final GrammarSampleMapper grammarSampleMapper;
    private final TestOptionRepository testOptionRepository;


    public Book addBook(AddBookRequest request){
        if (bookRepository.existsByTitle(request.getTitle())) {
            throw new BookAlreadyExistExeption();
        }
        var book = new Book();
        book.setTitle(request.getTitle());
        bookRepository.save(book);

        return book;

    }

    public LessonResponseDto addLesson(AddLessonRequest request){
        var book = bookRepository.findById(request.getBookId())
                .orElseThrow(BookNotFoundException::new);

        var lesson = new Lesson();
        lesson.setTitle(request.getTitle());
        lesson.setBook(book);
        book.addLesson(lesson);
        lessonRepository.save(lesson);

        return lessonMapper.toDto(lesson);
    }

    public SectionResponseDto addSection(AddSectionRequest request){
        var lesson = lessonRepository.findById(request.getLessonId())
                .orElseThrow(LessonNotFoundException::new);

        var section = new Section(request.getType(), request.getTitle());
        lesson.addSection(section);
        sectionRepository.save(section);

        return sectionMapper.toDto(section);

    }

    public VocabularySectionResponseDto addVocabulary(AddVocabularyRequest request){
        var section = sectionRepository.findById(request.getSectionId())
                .orElseThrow(SectionNotFoundException::new);

        var vocab = new Vocabulary(request.getJp(), request.getRomaji(), request.getEn());
        section.addVocab(vocab);
        vocabularyRepository.save(vocab);

        return vocabularyMapper.toDto(vocab);

    }

    public GrammarSectionResponseDto addGrammar(AddGrammarRequest request) {
        var section = sectionRepository.findById(request.getSectionId())
                .orElseThrow(SectionNotFoundException::new);

        var grammar = new Grammar();
        grammar.setContent(request.getContent());
        grammar.setFormula(request.getFormula());
        section.addGrammar(grammar);
        grammarRepository.save(grammar);

        return grammarMapper.toDto(grammar);

    }

    public GrammarSampleResponseDto addGrammarSample(AddGrammarSampleRequest request) {
        var grammar = grammarRepository.findById(request.getGrammarId())
                .orElseThrow(GrammarNotFoundException::new);

        var sample = new GrammarSample();
        sample.setEn(request.getEn());
        sample.setJp(request.getJp());
        grammar.addSample(sample);
        grammarSampleRepository.save(sample);

        return grammarSampleMapper.toDto(sample);

    }

    public AddTestResponse addTest(AddTestRequest request) {
        var lesson = lessonRepository.findById(request.getLessonId())
                .orElseThrow(LessonNotFoundException::new);

        var test = new Test();
        test.setTitle(request.getTitle());
        test.setDescription(request.getDescription());
        lesson.addTest(test);

        testRepository.save(test);

        return testMapper.toDto(test);

    }

    public AddQuestionResponse addQuestion(AddQuestionRequest request) {
        var test = testRepository.findById(request.getTestId())
                .orElseThrow(TestNotFoundException::new);

        var question = new TestQuestion();
        question.setQuestionText(request.getQuestion());
        question.setType(request.getType());
        test.addQuestions(question);

        questionRepository.save(question);

        return questionMapper.toDto(question);

    }

    public AddOptionResponse addOption(AddOptionRequest request) {
        var testQuestion = testQuestionRepository.findById(request.getQuestionId())
                .orElseThrow(TestQuestionNotFoundException::new);

        var option = new TestOption();
        option.setOptionText(request.getOptionText());
        option.setIsCorrect(request.getIsCorrect());
        testQuestion.addOptions(option);

        testOptionRepository.save(option);

        return testOptionMapper.toDto(option);

    }
}
