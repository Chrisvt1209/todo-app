package com.example.todobackend.dto.taskDto;

public record UpdateTaskRequest(
        String title,
        String description,
        String dueDate,
        boolean isCompleted) {
}
