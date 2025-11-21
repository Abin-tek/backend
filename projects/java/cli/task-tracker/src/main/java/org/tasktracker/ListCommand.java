package org.tasktracker;

import java.util.List;

public class ListCommand implements Command {
    private final TaskService service;
    private final Status callback;

    public ListCommand(TaskService service) {
        this.service = service;
        this.callback = service::parseStatus;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("More than one argument not allowed");
            Helper.showCommandFormat();
            return;
        }

        List<Task> tasks = service.listAll(callback.parseStatus(args));
        Response.send(tasks);
    }
}
