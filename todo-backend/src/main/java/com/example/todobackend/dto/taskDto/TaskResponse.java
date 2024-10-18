package com.example.todobackend.dto.taskDto;

public record TaskResponse(
        Long id,
        String title,
        String description,
        String dueDate,
        boolean isCompleted) {
}
