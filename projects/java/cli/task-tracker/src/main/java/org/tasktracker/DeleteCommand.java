package org.tasktracker;

public class DeleteCommand implements Command {
    private final TaskService service;

    public DeleteCommand(TaskService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Task id is required.");
            Helper.showCommandFormat();
            return;
        }

        String id = args[0];
        Task task = service.deleteTask(id);
        Response.send(
                "Task deleted successfully" +
                        task.prettyPrint()
        );
    }
}
