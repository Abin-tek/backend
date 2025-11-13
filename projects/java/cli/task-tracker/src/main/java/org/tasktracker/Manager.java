package org.tasktracker;

import java.util.HashSet;
import java.util.Set;

public class Manager {
    private static Manager instance;
    private final Set<String> actionList;

    private Manager() {
        this.actionList = new HashSet<>();
    }

    public static Manager getInstance() {
        if (instance == null)
            instance = new Manager();
        return instance;
    }

    public void addAction(String action) {
        actionList.add(action);
    }

    public boolean validAction(String action) {
        return actionList.contains(action);
    }
}
