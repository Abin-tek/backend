package org.tasktracker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private final Scanner sc;
    private Validator validator;

    public InputHandler() {
        this.sc = new Scanner(System.in);
    }

    protected String getUserInput() throws InputMismatchException {
        String user_input = sc.nextLine();

        while (!Validator.validate(user_input))
            user_input = sc.nextLine();

        return user_input;
    }
}
