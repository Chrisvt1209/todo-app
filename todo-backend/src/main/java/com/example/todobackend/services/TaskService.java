package com.example.todobackend.services;

import com.example.todobackend.models.TaskItem;
import com.example.todobackend.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(TaskItem taskItem) {
        taskRepository.save(taskItem);
    }

    public List<TaskItem> getTaskList() {
        return taskRepository.findAll();
    }

    public Optional<TaskItem> getTaskById(int id) {
        return taskRepository.findById(id);
    }

    public Optional<TaskItem> updateTask(int id, TaskItem updatedTaskItem) {
        return taskRepository.findById(id).map(
                taskItem -> {
                    taskItem.setTitle(updatedTaskItem.getTitle());
                    taskItem.setDescription(updatedTaskItem.getDescription());
                    taskItem.setCreatedAt(updatedTaskItem.getCreatedAt());
                    taskItem.setCompleted(updatedTaskItem.isCompleted());
                    return taskRepository.save(taskItem);
                });
    }

    public Optional<TaskItem> markTaskAsCompleted(int id) {
        return taskRepository.findById(id).map(
                taskItem -> {
                    taskItem.setCompleted(true);
                    return taskRepository.save(taskItem);
                });
    }

    public List<TaskItem> findTaskByCompletionStatus(boolean isCompleted) {
        return taskRepository.findByIsCompleted(isCompleted);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
