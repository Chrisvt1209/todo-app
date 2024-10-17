package com.example.todobackend.dto.taskitems;

import java.time.LocalDateTime;

public record UpdateTaskItemRequest(
        String title,
        String description,
        LocalDateTime createdAt) {
}
