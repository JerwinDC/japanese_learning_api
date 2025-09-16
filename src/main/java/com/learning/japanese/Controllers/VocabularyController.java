package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.VocabularySectionResponseDto;
import com.learning.japanese.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vocabularies")
public class VocabularyController {
    private final BookService bookService;

    @GetMapping("/{vocabularyId}")
    public ResponseEntity<VocabularySectionResponseDto> getLesson(
            @PathVariable(name = "vocabularyId") int vocabularyId)
    {

        var vocabDto = bookService.getVocab(vocabularyId);
        return ResponseEntity.ok().body(vocabDto);
    }
}
