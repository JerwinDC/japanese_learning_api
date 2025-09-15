package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.BookResponseDto;
import com.learning.japanese.Dtos.ErrorDto;
import com.learning.japanese.Entities.Book;
import com.learning.japanese.Exceptions.BookNotFoundException;
import com.learning.japanese.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBook(
            @PathVariable(name = "id") int id){

        return ResponseEntity.ok().body(bookService.getBook(id));
    }
}
