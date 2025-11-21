package org.tasktracker;

@FunctionalInterface
public interface Status {
    TaskStatus parseStatus(String[] args);
}
