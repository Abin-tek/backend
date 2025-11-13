package org.tasktracker;

public class Arguments {
    private final int number;
    private final String string;

    public Arguments(int number, String string) {
        this.number = number;
        this.string = string;
    }

    public int getNumber() {
        return number;
    }

    public String getString() {
        return string;
    }
}
