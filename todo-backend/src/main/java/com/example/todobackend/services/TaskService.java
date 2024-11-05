package com.example.todobackend.services;

import com.example.todobackend.exceptions.NotFoundException;
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

    public Task getTaskById(long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found."));
    }

    public void updateTask(long id, Task updatedTask) {
        Optional<Task> getTask = taskRepository.findById(id);

        if (getTask.isPresent()) {
            Task taskToUpdate = getTask.get();
            taskToUpdate.setTitle(updatedTask.getTitle());
            taskToUpdate.setDescription(updatedTask.getDescription());
            taskToUpdate.setDueDate(updatedTask.getDueDate());
            taskToUpdate.setCompleted(updatedTask.isCompleted());
            taskToUpdate.setTaskPriority(updatedTask.getTaskPriority());
            taskRepository.save(taskToUpdate);
        } else {
            throw new NotFoundException("Task not found.");
        }
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
