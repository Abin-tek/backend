package org.tasktracker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonTaskRepository implements TaskRepository {
    private final String FILE_PATH;
    private final ObjectMapper mapper;

    public JsonTaskRepository(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<Task> findAll() {
        return load();
    }

    @Override
    public Optional<Task> findById(String id) {
        return load().stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    @Override
    public void save(Task task) {
        List<Task> tasks = load();

        tasks.removeIf(t -> t.getId().equals(task.getId()));
        tasks.add(task);

        write(tasks);
    }

    @Override
    public void deleteById(String id) {
        List<Task> tasks = load();

        boolean removed = tasks.removeIf(t -> t.getId().equals(id));
        write(tasks);
    }

    private List<Task> load() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new ArrayList<>();
            return mapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
    }

    private void write(List<Task> tasks) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), tasks);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file", e);
        }
    }
}
