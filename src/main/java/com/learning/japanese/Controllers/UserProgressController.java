package com.learning.japanese.Controllers;

import com.learning.japanese.Service.UserProgressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/progress")
public class UserProgressController {
    private final UserProgressService userProgressService;

    @PostMapping("/{lessonId}")
    public ResponseEntity<Void> markLessonCompleted(
            @PathVariable int lessonId
            ){

        userProgressService.markComplete(lessonId);
        return ResponseEntity.ok().build();
    }
}
