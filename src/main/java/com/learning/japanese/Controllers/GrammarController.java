package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.GrammarSectionResponseDto;
import com.learning.japanese.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/grammars")
public class GrammarController {
    private final BookService bookService;

    @GetMapping("/{grammarId}")
    public ResponseEntity<GrammarSectionResponseDto> getLesson(
            @PathVariable(name = "grammarId") int grammarId)
    {

        var grammarDto = bookService.getGrammar(grammarId);
        return ResponseEntity.ok().body(grammarDto);

    }
}
