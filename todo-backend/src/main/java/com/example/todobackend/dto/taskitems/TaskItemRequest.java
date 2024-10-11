package com.example.todobackend.dto.todoitems;

public record TaskItemRequest(String title, String description, boolean isCompleted) {
}
