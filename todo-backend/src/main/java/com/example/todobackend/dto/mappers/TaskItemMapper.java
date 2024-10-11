package com.example.todobackend.dto.mappers;

import com.example.todobackend.dto.taskitems.TaskItemRequest;
import com.example.todobackend.dto.taskitems.TaskItemResponse;
import com.example.todobackend.models.TaskItem;

public class TaskItemMapper {
    public static TaskItemResponse toResponse(TaskItem taskItem) {
        return new TaskItemResponse(
                taskItem.getId(),
                taskItem.getTitle(),
                taskItem.getDescription(),
                taskItem.getCreatedAt(),
                taskItem.isCompleted()
        );
    }

    public static TaskItem toDomain(TaskItemRequest request) {
        return new TaskItem(
                request.title(),
                request.description(),
                request.createdAt(),
                request.isCompleted()
        );
    }
}
