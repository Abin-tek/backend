package org.tasktracker;

public class CommandNotExistException extends Exception {
    public CommandNotExistException() {
        super("Command not exist.");
    }
}
