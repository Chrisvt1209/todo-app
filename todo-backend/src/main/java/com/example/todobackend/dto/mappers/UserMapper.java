package com.example.todobackend.dto.mappers;

import com.example.todobackend.dto.userDto.UserRequest;
import com.example.todobackend.dto.userDto.UserResponse;
import com.example.todobackend.models.User;

public class UserMapper {
    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public static User toUser(UserRequest request) {
        return new User(
                request.name(),
                request.email(),
                request.password()
        );
    }
}
