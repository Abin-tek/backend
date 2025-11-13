package org.tasktracker;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            Commander commander = new Commander();
            commander.invokeOperation(args);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            showSugestion();
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showSugestion() {
    }
}