package com.example.todobackend.dto.userDto;

public record UserRequest(
        String name,
        String email,
        String password
) {
}
