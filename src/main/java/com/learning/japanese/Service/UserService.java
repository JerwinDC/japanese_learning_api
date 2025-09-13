package com.learning.japanese.Service;

import com.learning.japanese.Dtos.RegisterUserResponse;
import com.learning.japanese.Entities.User;
import com.learning.japanese.Exceptions.NotFoundException;
import com.learning.japanese.Mappers.UserMapper;
import com.learning.japanese.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public RegisterUserResponse getUser(int id){
        var user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with ID " + id));
        return userMapper.toDto(user);
    }

    public List<RegisterUserResponse> getAllUsers(){
        List<RegisterUserResponse> listOfUsers = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            listOfUsers.add(userMapper.toDto(user));
        });

        if(listOfUsers.isEmpty()){
            throw new NotFoundException("No registered users");
        }

        return listOfUsers;
    }

}
