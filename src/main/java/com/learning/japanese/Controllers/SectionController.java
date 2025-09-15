package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.SectionResponseDto;
import com.learning.japanese.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class SectionController {
    private final BookService bookService;

    @GetMapping("/{bookId}/lessons/{lessonId}/sections/{sectionId}")
    public ResponseEntity<SectionResponseDto> getLesson(
            @PathVariable(name = "bookId") int bookId,
            @PathVariable(name = "lessonId") int lessonId,
            @PathVariable(name = "sectionId") int sectionId)
    {
        var sectionDto = bookService.getSection(bookId, lessonId, sectionId);
        return ResponseEntity.ok().body(sectionDto);
    }
}
