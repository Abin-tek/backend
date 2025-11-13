package org.tasktracker;

public abstract class Action {
    private final String name;
    private final Manager manager;

    public Action(String name) {
        this.name = name;
        manager = Manager.getInstance();
        includeNewAction();
    }

    private void includeNewAction() {
        manager.addAction(name);
    }

    public String getName() {
        return name;
    }
}
