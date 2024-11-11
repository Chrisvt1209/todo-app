package com.example.todobackend.dto.mappers;

import com.example.todobackend.dto.taskDto.TaskRequest;
import com.example.todobackend.dto.taskDto.TaskResponse;
import com.example.todobackend.dto.taskDto.UpdateTaskRequest;
import com.example.todobackend.models.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskMapper {
    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                task.isCompleted(),
                task.getTaskPriority()
        );
    }

    public static Task toDomain(TaskRequest request) {
        return new Task(
                request.title(),
                request.description(),
                LocalDate.parse(request.dueDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                request.taskPriority()
        );
    }

    public static Task toUpdatedTask(Task task, UpdateTaskRequest request) {
        return new Task(
                task.getId(),
                request.title(),
                request.description(),
                LocalDate.parse(request.dueDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                request.isCompleted(),
                request.taskPriority()
        );
    }
}
