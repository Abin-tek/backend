package org.tasktracker;

public class CommandNotExistException extends Exception {
    public CommandNotExistException() {
        super("command not exist");
    }
}
