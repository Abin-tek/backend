package org.tasktracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private final String id;
    private String description;
    private TaskStatus status;
    private final String created_at;
    private String updated_at;

    @SuppressWarnings("used by jackson")
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

    @SuppressWarnings("used by jackson")
    public String  getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    @SuppressWarnings("used by jackson")
    public String getCreated_at() {
        return created_at;
    }

    @SuppressWarnings("used by jackson")
    public String getUpdated_at() {
        return updated_at;
    }

    public void mark(TaskStatus status) {
        this.status = status;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }


    @Override
    public String toString() {
        return "\nTask{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                "}\n"
                ;
    }

    public String prettyPrint() {
        return "\nTask details\n" +
                " Id: " + id + "\n" +
                " Description: " + description + "\n" +
                " Status: " + status + "\n" +
                " Created_at: " + created_at + "\n" +
                " Updated_at: " + updated_at + "\n"
                ;
    }
}
