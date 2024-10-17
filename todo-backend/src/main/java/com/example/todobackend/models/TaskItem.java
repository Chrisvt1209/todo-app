package com.example.todobackend.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "TaskItems")
public class TaskItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean isCompleted = false;

    public TaskItem() {
    }

    public TaskItem(String title, String description, LocalDateTime createdAt, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.isCompleted = isCompleted;
    }

    public TaskItem(String title, String description, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
