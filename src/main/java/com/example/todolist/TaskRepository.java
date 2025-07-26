package com.example.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // This interface is intentionally empty.
    // Spring Data JPA provides all the necessary methods like save(), findAll(), deleteById().
}