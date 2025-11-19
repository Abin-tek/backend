package org.tasktracker;

import java.util.List;

public class ListCommand implements Command {
    private final TaskService service;

    public ListCommand(TaskService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("No arguments required");
            Helper.showCommandFormat();
            return;
        }

        TaskStatus status = getStatus(args);
        List<Task> tasks = service.listAll(status);
        Response.send(tasks);
    }

    private TaskStatus getStatus(String[] args) {
        if (args.length == 0)
            return null;

        return switch (args[0]) {
            case "todo" -> TaskStatus.TODO;
            case "in-progress" -> TaskStatus.IN_PROGRESS;
            case "done" -> TaskStatus.DONE;
            default -> throw new IllegalStateException("Unexpected value: " + args[0]);
        };
    }
}
