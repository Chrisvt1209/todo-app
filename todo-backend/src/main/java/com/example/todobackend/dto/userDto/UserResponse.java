package com.example.todobackend.dto.userDto;

public record UserResponse(
        Long id,
        String name,
        String email
) {
}
