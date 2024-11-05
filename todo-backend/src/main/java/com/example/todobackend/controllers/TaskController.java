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
        Task task = taskService.getTaskById(id);
        TaskResponse response = TaskMapper.toResponse(task);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTodoPriority(@PathVariable long id, @RequestBody UpdateTaskRequest request) {
        Task task = taskService.getTaskById(id);
        task.setTaskPriority(request.taskPriority());
        taskService.updateTask(id, task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponse> deleteTodo(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
