package com.example.todobackend.services;

import com.example.todobackend.models.Task;
import com.example.todobackend.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getTaskList() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(
                task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setDueDate(updatedTask.getDueDate());
                    task.setCompleted(updatedTask.isCompleted());
                    return taskRepository.save(task);
                });
    }

    public Optional<Task> markTaskAsCompleted(Long id) {
        return taskRepository.findById(id).map(
                task -> {
                    task.setCompleted(true);
                    return taskRepository.save(task);
                });
    }

    public List<Task> findTaskByCompletionStatus(boolean isCompleted) {
        return taskRepository.findByIsCompleted(isCompleted);
    }

    public List<Task> findTasksByDueDate(LocalDate dueDate) {
        return taskRepository.findTasksByDueDate(dueDate);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
