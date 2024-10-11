package com.example.todobackend.services;

import com.example.todobackend.models.TaskItem;
import com.example.todobackend.repositories.TaskItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskItemService {
    private final List<TaskItem> todoList;
    private final TaskItemRepository taskItemRepository;

    public TaskItemService(TaskItemRepository taskItemRepository) {
        this.taskItemRepository = taskItemRepository;
        this.todoList = new ArrayList<>();
    }

    public void createTodoItem(TaskItem taskItem) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TaskItem> getTodoList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TaskItem updateTodoItem(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deleteTodoItem(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
