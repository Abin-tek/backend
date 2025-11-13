package org.tasktracker;

public class AddTask extends Action implements Operation{

    private AddTask() {
        super("add");
    }

    @Override
    public void execute(Arguments arguments) {
        String description = arguments.getString();
        Task new_task = new Task(description);
        
    }

    @Override
    public boolean isValid(String[] args) {
        return false;
    }
}
