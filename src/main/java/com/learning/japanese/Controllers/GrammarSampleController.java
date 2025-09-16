package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.GrammarSampleResponseDto;
import com.learning.japanese.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/grammars/samples")
public class GrammarSampleController {
    private final BookService bookService;

    @GetMapping("/{grammarSampleId}")
    public ResponseEntity<GrammarSampleResponseDto> getLesson(
            @PathVariable(name = "grammarSampleId") int grammarSampleId)
    {

        var grammarSampleDto = bookService.getGrammarSample(grammarSampleId);
        return ResponseEntity.ok().body(grammarSampleDto);
    }

}
