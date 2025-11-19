package org.tasktracker;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            Response.send("No command provided");
            Helper.showCommandFormat();
            return;
        }

        String commandName = args[0];
        String[] options = Arrays.copyOfRange(args, 1, args.length);

        TaskRepository repository = new JsonTaskRepository("tasks.json");
        TaskService service = new TaskService(repository);
        CommandFactory factory = new CommandFactory(service);

        try {
            Command command = factory.getCommand(commandName);
            command.execute(options);
        } catch (CommandNotExistException e) {
            throw new RuntimeException(e);
        }
    }
}