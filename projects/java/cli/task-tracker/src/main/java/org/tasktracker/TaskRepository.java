package org.tasktracker;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    public List<Task> findAll();

    public Optional<Task> findById(String id);

    public void save(Task task);

    public void deleteById(String id);
}
