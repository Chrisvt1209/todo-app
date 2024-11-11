package com.example.todobackend.taskTests;

import com.example.todobackend.exceptions.NotFoundException;
import com.example.todobackend.models.Task;
import com.example.todobackend.models.TaskPriority;
import com.example.todobackend.repositories.TaskRepository;
import com.example.todobackend.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceUnitTests {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task sampleTask;

    @BeforeEach
    public void setUp() {
        sampleTask = new Task(
                1L,
                "Task 1",
                "Optional description",
                LocalDate.now(),
                false,
                TaskPriority.LOW);
    }

    @Test
    public void createTask_ShouldSaveTask() {
        taskService.createTask(sampleTask);
        verify(taskRepository, times(1)).save(sampleTask);
    }

    @Test
    public void getTaskList_ShouldReturnAllTasks() {
        when(taskRepository.findAll()).thenReturn(List.of(sampleTask));
        List<Task> tasks = taskService.getTaskList();
        assertEquals(1, tasks.size());
        assertEquals(sampleTask, tasks.getFirst());
    }

    @Test
    public void getTaskById_ShouldReturnTask_WhenIdExists() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(sampleTask));
        Task task = taskService.getTaskById(1L);
        assertEquals(sampleTask, task);
    }

    @Test
    public void getTaskById_ShouldThrowException_WhenIdDoesNotExist() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> taskService.getTaskById(1L));
    }

    @Test
    public void updateTask_ShouldUpdateExistingTask_WhenIdExists() {
        // Arrange
        Task updatedTask = new Task();
        updatedTask.setTitle("Updated task");
        updatedTask.setDescription("Updated description");
        updatedTask.setDueDate(LocalDate.now().plusDays(1));
        updatedTask.setCompleted(true);
        updatedTask.setTaskPriority(TaskPriority.HIGH);

        // Act
        when(taskRepository.findById(1L)).thenReturn(Optional.of(sampleTask));
        taskService.updateTask(1L, updatedTask);

        // Assert
        verify(taskRepository, times(1)).save(sampleTask);
        assertEquals("Updated task", sampleTask.getTitle());
        assertEquals("Updated description", sampleTask.getDescription());
        assertEquals(LocalDate.now().plusDays(1), sampleTask.getDueDate());
        assertTrue(sampleTask.isCompleted());
        assertEquals(TaskPriority.HIGH, sampleTask.getTaskPriority());
    }

    @Test
    public void updateTask_ShouldThrowException_WhenIdDoesNotExist() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());
        Task updatedTask = new Task();
        assertThrows(NotFoundException.class, () -> taskService.updateTask(1L, updatedTask));
    }

    @Test
    public void findTasksByCompletionStatus_ShouldReturnTasksWithGivenStatus() {
        when(taskRepository.findByIsCompleted(false)).thenReturn(List.of(sampleTask));
        List<Task> tasks = taskService.findTaskByCompletionStatus(false);
        assertEquals(1, tasks.size());
        assertEquals(sampleTask, tasks.getFirst());
    }

    @Test
    public void findTasksByDueDate_ShouldReturnTasksWithGivenDueDate() {
        // Arrange
        LocalDate dueDate = LocalDate.now();
        when(taskRepository.findTasksByDueDate(dueDate)).thenReturn(List.of(sampleTask));

        // Act
        List<Task> tasks = taskService.findTasksByDueDate(dueDate);

        // Assert
        assertEquals(1, tasks.size());
        assertEquals(sampleTask, tasks.getFirst());
    }

    @Test
    public void deleteTask_ShouldDeleteTaskById() {
        taskService.deleteTask(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }
}
