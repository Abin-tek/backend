package org.tasktracker;

public class Helper {
    public static void showCommandFormat() {
        System.out.println(
                """
                            The command format should be : task-cli <command> [options]
                            to know available commands, just type : task-cli --help
                        """
        );
    }

    public static void help() {
        System.out.println(
                """
                           The command format should be : task-cli <command> [options]
                           command :-
                               add : to add new task
                               update : to update the description of a task using id
                               delete : to delete a task using id
                               mark-in-progress : to mark a task as in progress status using id
                               mark-done : to mark a task as done status using id
                               list : to list all tasks using status
                           options :-
                               "string in quotes" : to provide description
                               id : a unique identifier to access particular task
                               todo : use with list command to filter tasks with status TODO
                               in-progress : use with list command to filter tasks with status IN-PROGRESS
                               done : use with list command to filter tasks with status DONE
                        """
        );
    }
}