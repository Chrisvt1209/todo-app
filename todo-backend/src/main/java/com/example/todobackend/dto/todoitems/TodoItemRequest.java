package com.example.todobackend.dto.todoitems;

public record TodoItemRequest(String title, String description, boolean isCompleted) {
}
