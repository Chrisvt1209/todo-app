package com.example.todobackend.dto.todoitems;

public record TaskItemResponse(int id, String title, String description, boolean isCompleted) {
}
