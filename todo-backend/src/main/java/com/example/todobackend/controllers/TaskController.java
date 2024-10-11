package com.example.todobackend.controllers;

import com.example.todobackend.dto.mappers.TaskItemMapper;
import com.example.todobackend.dto.taskitems.TaskItemRequest;
import com.example.todobackend.dto.taskitems.TaskItemResponse;
import com.example.todobackend.models.TaskItem;
import com.example.todobackend.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskItemResponse> createTodoItem(@RequestBody TaskItemRequest request) {
        TaskItem taskItem = TaskItemMapper.toDomain(request);
        taskService.createTask(taskItem);
        TaskItemResponse response = TaskItemMapper.toResponse(taskItem);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskItemResponse>> getTodoList(@RequestBody TaskItemRequest request) {
        List<TaskItem> taskItems = taskService.getTaskList();
        List<TaskItemResponse> response = taskItems.stream()
                .map(TaskItemMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskItemResponse> updateTodoItem(@PathVariable int id, TaskItemRequest request) {
        TaskItem updatedTaskItem = TaskItemMapper.toDomain(request);
        return taskService.updateTask(id, updatedTaskItem)
                .map(TaskItemMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskItemResponse> deleteTodoItem(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
