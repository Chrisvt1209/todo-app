package com.example.todobackend.services;

import com.example.todobackend.models.TodoItem;
import com.example.todobackend.repositories.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {
    private final TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public void createTodoItem(TodoItem todoItem) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TodoItem> getTodoList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TodoItem updateTodoItem(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteTodoItem(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
