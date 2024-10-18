package com.example.todobackend.dto.taskDto;

public record TaskRequest(
        String title,
        String description,
        String dueDate) {
}
