package org.tasktracker;

import java.util.Arrays;

public class MarkCommand implements Command {
    private final TaskService service;
    private final Status callback;

    public MarkCommand(TaskService service) {
        this.service = service;
        callback = service::parseStatus;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Task id and status is required");
            Helper.showCommandFormat();
            return;
        }

        String id = args[0];
        args = Arrays.copyOfRange(args, 1, args.length);
        Task task = service.mark(id, callback.parseStatus(args));
        Response.send(
                "Task updated successfully" +
                        task.prettyPrint()
        );
    }
}
