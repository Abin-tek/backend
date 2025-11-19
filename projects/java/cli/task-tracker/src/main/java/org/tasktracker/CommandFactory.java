package org.tasktracker;

import java.util.HashSet;
import java.util.Set;

public class CommandFactory {
    private final TaskService service;

    public CommandFactory(TaskService service) {
        this.service = service;
    }

    public Command getCommand(String name) throws CommandNotExistException {
        return switch (name) {
            case "add" -> new AddCommand(service);
            case "update" -> new UpdateCommand(service);
            case "delete" -> new DeleteCommand(service);
//            add others...
            default -> throw new CommandNotExistException();
        };
    }
}
