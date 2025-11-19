package org.tasktracker;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();

    Optional<Task> findById(String id);

    void save(Task task);

    void deleteById(String id);
}
