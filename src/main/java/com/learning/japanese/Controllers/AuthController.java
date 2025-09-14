package com.learning.japanese.Controllers;

import com.learning.japanese.Config.JwtConfig;
import com.learning.japanese.Dtos.*;
import com.learning.japanese.Exceptions.EmailAlreadyUsedException;
import com.learning.japanese.Repositories.UserRepository;
import com.learning.japanese.Service.AuthService;
import com.learning.japanese.Service.JwtService;
import com.learning.japanese.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Authentication")
@AllArgsConstructor
@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final UserService userService;
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final JwtConfig jwtConfig;
    private final UserRepository userRepository;

    @Operation(summary = "Register a new user")
    @ApiResponse(responseCode = "201", description = "User registered successfully")
    @ApiResponse(responseCode = "400", description = "Email already used")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder
            ){
        var response = authService.registerNewUser(request);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @Operation(summary = "Login")
    @ApiResponse(responseCode = "200", description = "User logged in successfully")
    @ApiResponse(responseCode = "401", description = "Invalid email or password")
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(
            @Valid @RequestBody LoginUserRequest request,
            HttpServletResponse response){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var accessToken = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        var cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(true);
        cookie.setPath("/api/auth/refresh");
        cookie.setMaxAge(jwtConfig.getRefreshTokenExpiration());
        cookie.setSecure(true);

        response.addCookie(cookie);


        return ResponseEntity.ok(new JwtResponse(accessToken));
    }

    @GetMapping("/me")
    public ResponseEntity<RegisterUserResponse> getCurrentLoginUser(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var id = (String) authentication.getPrincipal();

        var userDto = userService.getUser(Integer.parseInt(id));
        return ResponseEntity.ok().body(userDto);

    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refresh(
            @CookieValue(name = "refreshToken") String refreshToken
    ){
        if(!jwtService.validateToken(refreshToken)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        var userID = jwtService.getIdFromToken(refreshToken);
        var user = userRepository.findById(Integer.parseInt(userID)).orElseThrow();
        var accessToken = jwtService.generateAccessToken(user);

        return ResponseEntity.ok().body(new JwtResponse(accessToken));


    }


    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<ErrorDto> handleEmailAlreadyUsedException(){
        return ResponseEntity.badRequest().body(new ErrorDto("Email already used!"));
    }
}
