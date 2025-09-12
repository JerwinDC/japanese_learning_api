package com.learning.japanese.Dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterUserResponse {
    private int id;
    private String email;
    private LocalDateTime createdAt;
}
