package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.RegisterUserResponse;
import com.learning.japanese.Entities.User;
import com.learning.japanese.Repositories.UserRepository;
import com.learning.japanese.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "User")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Get user data using id")
    @ApiResponse(responseCode = "200", description = "User data is available")
    @ApiResponse(responseCode = "404", description = "User not found")
    @GetMapping("/{id}")
    public ResponseEntity<RegisterUserResponse> getUser(
            @PathVariable(name = "id") int id){

        var userData = userService.getUser(id);
        return ResponseEntity.ok().body(userData);
    }

    @Operation(summary = "Get all users data")
    @ApiResponse(responseCode = "200", description = "User data is available")
    @ApiResponse(responseCode = "404", description = "User not found")
    @GetMapping
    public ResponseEntity<List<RegisterUserResponse>> getAllUsers(){
        var usersData = userService.getAllUsers();
        return ResponseEntity.ok().body(usersData);
    }

}
