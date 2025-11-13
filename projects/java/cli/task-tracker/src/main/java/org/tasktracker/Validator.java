package org.tasktracker;

public class Validator {

    protected static boolean validate(String input) {
        String[] input_arr = input.split(" ");
        Manager manager = Manager.getInstance();

        if (input_arr.length > 0 && manager.validAction(input_arr[0]))
            return false;

        return true;
    }

}
