package com.example.todobackend.dto.todoitems;

public record TodoItemResponse(int id, String title, String description, boolean isCompleted) {
}
