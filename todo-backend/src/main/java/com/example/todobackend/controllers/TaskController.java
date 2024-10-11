package com.example.todobackend.controllers;

import com.example.todobackend.dto.todoitems.TaskItemRequest;
import com.example.todobackend.dto.todoitems.TaskItemResponse;
import com.example.todobackend.services.TaskItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoItemController {
    private final TaskItemService taskItemService;

    public TodoItemController(TaskItemService taskItemService) {
        this.taskItemService = taskItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskItemResponse> createTodoItem(@RequestBody TaskItemRequest request) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskItemResponse>> getTodoList(@RequestBody TaskItemRequest request) {
        throw new UnsupportedOperationException();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskItemResponse> updateTodoItem(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskItemResponse> deleteTodoItem(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
