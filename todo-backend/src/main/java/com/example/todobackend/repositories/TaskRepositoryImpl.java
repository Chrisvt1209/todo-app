package com.example.todobackend.repositories;

import com.example.todobackend.models.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepositoryCustom {
    private final EntityManager entityManager;

    public TaskRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Task> findTasksByDueDate(LocalDate dueDate) {
        TypedQuery<Task> query = entityManager.createQuery(
                "SELECT t FROM Task t WHERE t.dueDate = :dueDate", Task.class);
        query.setParameter("dueDate", dueDate);
        return query.getResultList();
    }
}
