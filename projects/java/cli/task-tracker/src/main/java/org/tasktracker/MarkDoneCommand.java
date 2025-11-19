package org.tasktracker;

public class MarkDoneCommand implements Command {
    private final TaskService service;

    public MarkDoneCommand(TaskService service) {
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
        Task task = service.markDone(id);
        Response.send(
                "Task updated successfully\n" +
                        task.toString()
        );
    }
}
