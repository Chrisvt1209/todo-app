package com.example.todobackend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TodoList {
    private List<TodoItem> todoItemList = new ArrayList<>();

    public TodoList(List<TodoItem> todoItemList) {
        this.todoItemList = todoItemList;
    }
}
