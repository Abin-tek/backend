package org.tasktracker;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException() {
        super("task not found");
    }
}
