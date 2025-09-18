package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.*;
import com.learning.japanese.Entities.Book;
import com.learning.japanese.Exceptions.BookAlreadyExistExeption;
import com.learning.japanese.Service.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("hello")
    public String sayHello(){
        return  "Hello Admin";
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(
            @Valid @RequestBody AddBookRequest request,
            UriComponentsBuilder uriBuilder
            ){

            var book = adminService.addBook(request);
            var uri = uriBuilder.path("/api/books/{id}").buildAndExpand(book.getId()).toUri();

            return ResponseEntity.created(uri).body(book);
    }

    @PostMapping("/lessons")
    public ResponseEntity<LessonResponseDto> addLesson(
            @Valid @RequestBody AddLessonRequest request,
            UriComponentsBuilder uriBuilder
            ){

            var lessonDto = adminService.addLesson(request);
            var uri = uriBuilder.path("/api/lessons/{lessonId}").buildAndExpand(lessonDto.getId()).toUri();

            return ResponseEntity.created(uri).body(lessonDto);

    }

    @PostMapping("/sections")
    public ResponseEntity<SectionResponseDto> addSection(
            @Valid @RequestBody AddSectionRequest request,
            UriComponentsBuilder uriBuilder
            ){

            var sectionDto = adminService.addSection(request);
            var uri = uriBuilder.path("/api/sections/{sectionId}")
                    .buildAndExpand(sectionDto.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(sectionDto);

    }

    @PostMapping("/sections/vocabularies")
    public ResponseEntity<VocabularySectionResponseDto> addVocabulary(
            @Valid @RequestBody AddVocabularyRequest request,
            UriComponentsBuilder uriBuilder
    ){

            var vocabularyDto = adminService.addVocabulary(request);
            var uri = uriBuilder.path("/api/vocabularies/{vocabularyId}")
                .buildAndExpand(vocabularyDto.getId())
                .toUri();

            return ResponseEntity.created(uri).body(vocabularyDto);
    }

    @PostMapping("/sections/grammars")
    public ResponseEntity<GrammarSectionResponseDto> addGrammar(
            @Valid @RequestBody AddGrammarRequest request,
            UriComponentsBuilder uriBuilder
    ){

        var grammarDto = adminService.addGrammar(request);
        var uri = uriBuilder.path("/api/grammars/{grammarId}")
                .buildAndExpand(grammarDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(grammarDto);
    }

    @PostMapping("/sections/grammars/samples")
    public ResponseEntity<GrammarSampleResponseDto> addGrammarSample(
            @Valid @RequestBody AddGrammarSampleRequest request,
            UriComponentsBuilder uriBuilder
    ){

        var grammarSampleDto = adminService.addGrammarSample(request);
        var uri = uriBuilder.path("/samples/{id}")
                .buildAndExpand(grammarSampleDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(grammarSampleDto);
    }


    @PostMapping("/tests")
    public ResponseEntity<AddTestResponse> addTest(
            @Valid @RequestBody AddTestRequest request,
            UriComponentsBuilder uriBuilder){

            var addTestDto =  adminService.addTest(request);
            var uri = uriBuilder.path("/tests/{id}")
                .buildAndExpand(addTestDto.getId())
                .toUri();

            return ResponseEntity.created(uri).body(addTestDto);

    }

    @PostMapping("/questions")
    public ResponseEntity<AddQuestionResponse> addQuestion(
            @Valid @RequestBody AddQuestionRequest request,
            UriComponentsBuilder uriBuilder){

        var addQuestionDto =  adminService.addQuestion(request);
        var uri = uriBuilder.path("/questions/{id}")
                .buildAndExpand(addQuestionDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(addQuestionDto);

    }

    @PostMapping("/questions/options")
    public ResponseEntity<AddOptionResponse> addOptions(
            @Valid @RequestBody AddOptionRequest request,
            UriComponentsBuilder uriBuilder){

        var addOptionDto =  adminService.addOption(request);
        var uri = uriBuilder.path("/questions/options/{id}")
                .buildAndExpand(addOptionDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(addOptionDto);

    }


    @ExceptionHandler(BookAlreadyExistExeption.class)
    public ResponseEntity<ErrorDto> handleBookAlreadyExistException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto("Book already exist!"));
    }

}
