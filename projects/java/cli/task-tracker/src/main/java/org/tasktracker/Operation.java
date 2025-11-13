package org.tasktracker;

public interface Operation {
    void execute(Arguments arguments);

    boolean isValid(String[] args);
}
