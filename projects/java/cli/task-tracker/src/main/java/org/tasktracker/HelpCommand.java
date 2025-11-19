package org.tasktracker;

public class HelpCommand implements Command {

    @Override
    public void execute(String[] args) {
        Helper.help();
    }
}
