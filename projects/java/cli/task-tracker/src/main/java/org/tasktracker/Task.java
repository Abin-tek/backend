package org.tasktracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Task {
    private final String id;
    private String description;
    private TaskStatus status;
    private final String created_at;
    private String updated_at;

    public Task() {
        this.id = "";
        this.created_at = "";
    }

    public Task(String id, String description) {
        this.id = id;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.created_at = LocalDateTimeString();
        this.updated_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }


    public void markInProgress() {
        this.status = TaskStatus.IN_PROGRESS;
        update();
    }

    public void markDone() {
        this.status = TaskStatus.DONE;
        update();
    }

    public void updateDescription(String description) {
        this.description = description;
        update();
    }

    private void update() {
        this.updated_at = LocalDateTimeString();
    }

    private static String LocalDateTimeString() {
//        DateTimeFormatter formatter = new DateTimeFormatter()
        return LocalDateTime.now().toString();
    }

    @Override
    public String toString() {
        return "Task details\n" +
                "Id: " + id + "\n" +
                "Description: " + description + "\n" +
                "Status: " + status + "\n" +
                "Created_at: " + created_at + "\n" +
                "Updated_at: " + updated_at
                ;
    }
}
