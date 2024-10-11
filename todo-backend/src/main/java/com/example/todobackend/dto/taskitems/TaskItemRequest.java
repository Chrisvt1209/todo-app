package com.example.todobackend.dto.taskitems;

import java.time.LocalDateTime;

public record TaskItemRequest(
        String title,
        String description,
        LocalDateTime createdAt,
        boolean isCompleted) {
}
