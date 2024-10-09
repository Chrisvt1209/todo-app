package com.example.todobackend.controllers;

import com.example.todobackend.dto.todoitems.TodoItemRequest;
import com.example.todobackend.dto.todoitems.TodoItemResponse;
import com.example.todobackend.services.TodoItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo-items")
public class TodoItemController {
    private final TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<TodoItemResponse> createTodoItem(@RequestBody TodoItemRequest request) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/")
    public ResponseEntity<List<TodoItemResponse>> getTodoList(@RequestBody TodoItemRequest request) {
        throw new UnsupportedOperationException();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoItemResponse> updateTodoItem(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoItemResponse> deleteTodoItem(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
