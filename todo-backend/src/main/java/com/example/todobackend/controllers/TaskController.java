package com.example.todobackend.controllers;

import com.example.todobackend.dto.mappers.TaskItemMapper;
import com.example.todobackend.dto.taskitems.TaskItemRequest;
import com.example.todobackend.dto.taskitems.TaskItemResponse;
import com.example.todobackend.dto.taskitems.UpdateTaskItemRequest;
import com.example.todobackend.models.TaskItem;
import com.example.todobackend.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping()
    public ResponseEntity<List<TaskItemResponse>> getTodoList(@RequestBody TaskItemRequest request) {
        List<TaskItem> taskItems = taskService.getTaskList();
        List<TaskItemResponse> response = taskItems.stream()
                .map(TaskItemMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskItemResponse> getTodoById(@PathVariable int id) {
        Optional<TaskItem> taskItem = taskService.getTaskById(id);
        if (taskItem.isPresent()) {
            TaskItemResponse response = TaskItemMapper.toResponse(taskItem.get());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskItemResponse> updateTodoItem(@PathVariable int id, @RequestBody UpdateTaskItemRequest request) {
        TaskItem updatedTaskItem = TaskItemMapper.toUpdateTask(request);
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
