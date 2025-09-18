package com.learning.japanese.Exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.learning.japanese.Dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleExceptions(
            MethodArgumentNotValidException exception
    ){
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);

    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDto> handleBadCredentialsException(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new ErrorDto("Invalid email or password")
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFound(NotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(ex.getMessage()));
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDto> handleBookNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Book not found!"));
    }

    @ExceptionHandler(LessonNotFoundException.class)
    public ResponseEntity<ErrorDto> handleLessonNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Lesson not found!"));
    }

    @ExceptionHandler(SectionNotFoundException.class)
    public ResponseEntity<ErrorDto> handleSectionNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Section not found!"));
    }

    @ExceptionHandler(GrammarNotFoundException.class)
    public ResponseEntity<ErrorDto> handleGrammarNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Grammar not found!"));
    }

    @ExceptionHandler(TestNotFoundException.class)
    public ResponseEntity<ErrorDto> handleTestNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Test not found!"));
    }

    @ExceptionHandler(TestQuestionNotFoundException.class)
    public ResponseEntity<ErrorDto> handleTestQuestionNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Test question not found!"));
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleEnumErrors(HttpMessageNotReadableException ex) {
        if (ex.getCause() instanceof InvalidFormatException invalidFormatException &&
                invalidFormatException.getTargetType().isEnum()) {

            Class<?> enumType = invalidFormatException.getTargetType();
            String[] acceptedValues = Arrays.stream(enumType.getEnumConstants())
                    .map(Object::toString)
                    .toArray(String[]::new);

            Map<String, String> error = new HashMap<>();
            error.put("error", "Invalid value for enum");
            error.put("supportedValues", String.join(", ", acceptedValues));
            return ResponseEntity.badRequest().body(error);
        }

        // fallback for other cases
        Map<String, String> error = new HashMap<>();
        error.put("error", "Invalid request format");
        return ResponseEntity.badRequest().body(error);
    }



}
