package org.tasktracker;

public class CommandFactory {
    private final TaskService service;

    public CommandFactory() {
        this.service = new TaskService();
    }

    public Command getCommand(String name) throws CommandNotExistException {
        return switch (name) {
            case "add" -> new AddCommand(service);
            case "update" -> new UpdateCommand(service);
            case "delete" -> new DeleteCommand(service);
            case "mark" -> new MarkCommand(service);
            case "list" -> new ListCommand(service);
            case "--help" -> new HelpCommand();
//            add other commands...
            default -> throw new CommandNotExistException();
        };
    }
}
