package com.example.todobackend.dto.taskDto;

import com.example.todobackend.models.TaskPriority;

public record TaskResponse(
        Long id,
        String title,
        String description,
        String dueDate,
        boolean isCompleted,
        TaskPriority taskPriority) {
}
