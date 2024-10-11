package com.example.todobackend.repositories;

import com.example.todobackend.models.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskItem, Integer> {
    List<TaskItem> findByIsCompleted(boolean isCompleted);
}
