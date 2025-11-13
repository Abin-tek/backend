package org.tasktracker;

import java.time.LocalDateTime;

public class Task {
     static int id_generator = 0;
    private final int id;
    private String description;
    private Status status;
    private final LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Task(String description) {
        this.id = ++id_generator;
        this.description = description;
        this.status = Status.TODO;
        this.created_at = LocalDateTime.now();
        this.updated_at = created_at;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at() {
        this.updated_at = LocalDateTime.now();
    }
}
