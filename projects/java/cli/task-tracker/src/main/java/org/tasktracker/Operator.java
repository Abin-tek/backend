package org.tasktracker;

import java.util.Map;

public class Operator {
    private final Map<String, Operation> operationMap;

    public Operator(Map<String, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    public void performAction(Action action, Arguments arguments) {
        operationMap.get(action.getName()).execute(arguments);
    }

    public boolean performValidation(String action_name, String[] args) {
        return operationMap.get(action_name).isValid(args);
    }
}
