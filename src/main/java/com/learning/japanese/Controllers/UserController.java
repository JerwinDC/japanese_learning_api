package com.learning.japanese.Controllers;

import com.learning.japanese.Entities.User;
import com.learning.japanese.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<Optional<User>> registerUser(@RequestBody String email){
        var user = userRepository.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }

}
