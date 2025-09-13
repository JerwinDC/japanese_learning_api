package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.RegisterUserResponse;
import com.learning.japanese.Entities.User;
import com.learning.japanese.Repositories.UserRepository;
import com.learning.japanese.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<RegisterUserResponse> registerUser(
            @PathVariable(name = "id") int id){

        var userData = userService.getUser(id);
        return ResponseEntity.ok().body(userData);
    }

    @GetMapping
    public ResponseEntity<List<RegisterUserResponse>> getAllUsers(){
        var usersData = userService.getAllUsers();
        return ResponseEntity.ok().body(usersData);
    }

}
