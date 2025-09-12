package com.learning.japanese.Mappers;

import com.learning.japanese.Dtos.RegisterUserResponse;
import com.learning.japanese.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    RegisterUserResponse toDto(User user);
}
