package org.tasktracker;

import java.util.List;

public class TaskService {
    private final TaskRepository repository;

    public TaskService() {
        this.repository = new JsonTaskRepository("tasks.json");
    }

    public Task createTask(String description) {
        Task newTask = new Task(generateNumericId(), description);
        repository.save(newTask);
        return newTask;
    }

    public Task updateTask(String id, String description) {
        Task task = getTask(id);
        task.updateDescription(description);
        repository.save(task);
        return task;
    }

    public Task deleteTask(String id) {
        Task task = getTask(id);
        repository.deleteById(id);
        return task;
    }

    public Task mark(String id, TaskStatus status) {
        Task task = getTask(id);
        task.mark(status);
        repository.save(task);
        return task;
    }

    public List<Task> listAll(TaskStatus status) {
        List<Task> tasks = repository.findAll();

        if (status != null) {
            tasks = tasks.stream().filter(task -> task.getStatus().equals(status)).toList();
        }

        return tasks;
    }

    private Task getTask(String id) {
        try {
            return repository.findById(id).orElseThrow(TaskNotFoundException::new);
        } catch (TaskNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateNumericId() {
        return String.valueOf(
                repository.findAll().stream()
                        .mapToInt(t -> Integer.parseInt(t.getId()))
                        .max()
                        .orElse(0) + 1
        );
    }

    protected TaskStatus parseStatus(String[] args) {
        if (args.length == 0)
            return null;

        return switch (args[0]) {
            case "todo" -> TaskStatus.TODO;
            case "in-progress" -> TaskStatus.IN_PROGRESS;
            case "done" -> TaskStatus.DONE;
            default -> throw new IllegalStateException("Unexpected value: " + args[0]);
        };
    }
}
