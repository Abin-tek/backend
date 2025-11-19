package org.tasktracker;

public class UpdateCommand implements Command {
    private final TaskService service;

    public UpdateCommand(TaskService service) {
        this.service = service;
    }


    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Id and description are required.");
            Helper.showCommandFormat();
            return;
        }

        String id = args[0];
        String description = args[1];

        Task task = service.updateTask(id, description);
        Response.send(
                "Task updated successfully\n" +
                        task.toString()
        );
    }
}
