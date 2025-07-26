package com.example.todolist;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private boolean completed = false;

    // In Eclipse: Right-click -> Source -> Generate Getters and Setters...
    // Also generate a no-argument constructor and a constructor with the 'title' field.
    
    public Task() {}

    public Task(String title) {
        this.title = title;
    }

    // Getters and Setters below...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}