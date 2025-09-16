package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.ErrorDto;
import com.learning.japanese.Dtos.LessonResponseDto;
import com.learning.japanese.Exceptions.LessonNotFoundException;
import com.learning.japanese.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/lessons/")
public class LessonController {
    private final BookService bookService;

    @GetMapping("/{lessonId}")
    public ResponseEntity<LessonResponseDto> getLesson(
            @PathVariable(name = "lessonId") int lessonId)
    {
        var lessonDto = bookService.getLesson(lessonId);
        return ResponseEntity.ok().body(lessonDto);
    }

    @ExceptionHandler(LessonNotFoundException.class)
    public ResponseEntity<ErrorDto> handleLessonNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Lesson not found"));
    }

}
