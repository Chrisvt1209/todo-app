package com.example.todobackend.dto.taskDto;

import com.example.todobackend.models.TaskPriority;

public record UpdateTaskRequest(
        String title,
        String description,
        String dueDate,
        boolean isCompleted,
        TaskPriority taskPriority
) {
}
