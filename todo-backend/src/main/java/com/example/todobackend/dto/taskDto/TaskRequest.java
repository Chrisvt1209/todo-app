package com.example.todobackend.dto.taskDto;

import com.example.todobackend.models.TaskPriority;

public record TaskRequest(
        String title,
        String description,
        String dueDate,
        TaskPriority taskPriority) {
}
