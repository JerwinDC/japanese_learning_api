package com.learning.japanese.Controllers;

import com.learning.japanese.Dtos.ErrorDto;
import com.learning.japanese.Dtos.RegisterUserRequest;
import com.learning.japanese.Dtos.RegisterUserResponse;
import com.learning.japanese.Exceptions.EmailAlreadyUsedException;
import com.learning.japanese.Service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody RegisterUserRequest request
            ){
        var response = authService.registerNewUser(request);
        return ResponseEntity.ok().body(response);
    }

    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<ErrorDto> handleEmailAlreadyUsedException(){
        return ResponseEntity.badRequest().body(new ErrorDto("Email already used!"));
    }
}
