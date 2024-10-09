package com.example.todobackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TodoItem {
    @Id
    private int id;
    private String title;
    private String description;
    private boolean isCompleted = false;

    public TodoItem() {
    }

    public TodoItem(int id, String title, String description, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }
}
