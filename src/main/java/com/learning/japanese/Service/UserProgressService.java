package com.learning.japanese.Service;

import com.learning.japanese.Entities.UserProgress;
import com.learning.japanese.Exceptions.LessonNotFoundException;
import com.learning.japanese.Repositories.LessonRepository;
import com.learning.japanese.Repositories.UserProgressRepository;
import com.learning.japanese.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class UserProgressService {
    private final LessonRepository lessonRepository;
    private final UserRepository userRepository;
    private final UserProgressRepository userProgressRepository;

    public void markComplete(int lessonId){
        var lesson = lessonRepository.findById(lessonId)
                .orElseThrow(LessonNotFoundException::new);

        var userProgress = new UserProgress();

        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var userId = (String) authentication.getPrincipal();
        var user = userRepository.findById(Integer.parseInt(userId))
                .orElseThrow();

        userProgress.setCompleted(true);
        userProgress.setLesson(lesson);
        userProgress.setUser(user);
        userProgress.setUpdatedAt(LocalDateTime.now());

        userProgressRepository.save(userProgress);

    }

}
