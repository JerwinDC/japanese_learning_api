package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.ErrorDto;
import com.learning.japanese.Dtos.LessonResponseDto;
import com.learning.japanese.Entities.Lesson;
import com.learning.japanese.Exceptions.LessonNotFoundException;
import com.learning.japanese.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books/")
public class LessonController {
    private final BookService bookService;

    @GetMapping("/{bookId}/lessons/{lessonId}")
    public ResponseEntity<LessonResponseDto> getLesson(
            @PathVariable(name = "bookId") int bookId,
            @PathVariable(name = "lessonId") int lessonId)
    {
        var lessonDto = bookService.getLesson(bookId, lessonId);
        return ResponseEntity.ok().body(lessonDto);
    }

    @ExceptionHandler(LessonNotFoundException.class)
    public ResponseEntity<ErrorDto> handleLessonNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Lesson not found"));
    }

}
