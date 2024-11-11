package com.example.todobackend.taskTests;

import com.example.todobackend.models.Task;
import com.example.todobackend.models.TaskPriority;
import com.example.todobackend.repositories.TaskRepository;
import com.example.todobackend.services.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class TaskServiceUnitTests {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void createTaskItem_Succeeds() {
        // Arrange
        Task task = new Task(1L, "", "Test", LocalDateTime.now(), false, TaskPriority.LOW);

        // Act
        taskRepository.save(task);

        // Assert
        
    }
}
