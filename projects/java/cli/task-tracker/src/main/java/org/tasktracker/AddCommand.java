package org.tasktracker;

import java.util.Arrays;

public class AddCommand implements Command {
    private final TaskService service;

    public AddCommand(TaskService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            Response.send("Description is required.");
            Helper.showCommandFormat();
            return;
        }

        System.out.println(Arrays.toString(args));
        String description = args[0];
        Task task = service.createTask(description);
        Response.send(
                "Task added successfully\n" +
                        "Id: " + task.getId()
        );
    }
}
