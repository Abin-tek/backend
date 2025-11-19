package org.tasktracker;

import java.util.List;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(String description) {
        try {
            Task newTask = new Task(generateNumericId(), description);
            repository.save(newTask);
            return newTask;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Task updateTask(String id, String description) {
        Task task = getTask(id);
        task.updateDescription(description);
        repository.save(task);
        return task;
    }

    public boolean deleteTask(String id) {
        return repository.deleteById(id);
    }

    public void markInProgress(String id) {
        Task task = getTask(id);
        task.markInProgress();
    }


    public void markDone(String id) {
        Task task = getTask(id);
        task.markInProgress();
    }

    public List<Task> listAll(TaskStatus status) {
        return repository.findAll();
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
}
