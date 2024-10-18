package com.example.todobackend.repositories;

import com.example.todobackend.models.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepositoryCustom {
    List<Task> findTasksByDueDate(LocalDate dueDate);
}
