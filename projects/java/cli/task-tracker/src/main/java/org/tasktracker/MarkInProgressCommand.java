package org.tasktracker;

public class MarkInProgressCommand implements Command {
    private final TaskService service;

    public MarkInProgressCommand(TaskService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Task id is required");
            Helper.showCommandFormat();
            return;
        }

        String id = args[0];
        Task task = service.markInProgress(id);
        Response.send(
                "Task updated successfully" +
                        task.prettyPrint()
        );
    }
}
