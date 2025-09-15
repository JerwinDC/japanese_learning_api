package com.learning.japanese.Service;

import com.learning.japanese.Dtos.RegisterUserRequest;
import com.learning.japanese.Dtos.RegisterUserResponse;
import com.learning.japanese.Entities.User;
import com.learning.japanese.Exceptions.EmailAlreadyUsedException;
import com.learning.japanese.Exceptions.NotFoundException;
import com.learning.japanese.Mappers.UserMapper;
import com.learning.japanese.Repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EntityManager entityManager;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public RegisterUserResponse registerNewUser(RegisterUserRequest request) {
       if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyUsedException();
       }
        var encodedPassword = passwordEncoder.encode(request.getPassword());
        var user = new User(request.getEmail(), encodedPassword);
        var savedUser = userRepository.save(user);
        entityManager.refresh(savedUser);
        return userMapper.toDto(savedUser);
    }

    public RegisterUserResponse getUser(String email){
        var user = userRepository.findByEmail(email).orElse(null);
        if(user == null){
            throw new NotFoundException("User not found");
        }
        return userMapper.toDto(user);
    }
}
