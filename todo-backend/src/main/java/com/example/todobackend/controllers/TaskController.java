package com.example.todobackend.controllers;

import com.example.todobackend.dto.mappers.TaskMapper;
import com.example.todobackend.dto.taskDto.TaskRequest;
import com.example.todobackend.dto.taskDto.TaskResponse;
import com.example.todobackend.dto.taskDto.UpdateTaskRequest;
import com.example.todobackend.models.Task;
import com.example.todobackend.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/todo")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskResponse> createTodo(@RequestBody TaskRequest request) {
        Task task = TaskMapper.toDomain(request);
        taskService.createTask(task);
        TaskResponse response = TaskMapper.toResponse(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<List<TaskResponse>> getTodoList() {
        List<Task> tasks = taskService.getTaskList();
        List<TaskResponse> response = tasks.stream()
                .map(TaskMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTodoById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            TaskResponse response = TaskMapper.toResponse(task.get());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTodo(@PathVariable Long id, @RequestBody UpdateTaskRequest request) {
        Task updatedTask = TaskMapper.toUpdateTask(request);
        return taskService.updateTask(id, updatedTask)
                .map(TaskMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponse> deleteTodo(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
