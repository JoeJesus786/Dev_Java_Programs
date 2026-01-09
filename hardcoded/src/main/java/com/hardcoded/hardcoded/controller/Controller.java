package com.hardcoded.hardcoded.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardcoded.hardcoded.model.Task;

@RestController
@RequestMapping("/tasks")
public class Controller {

    private static final List<Task> taskList = new ArrayList<>();
    private static final AtomicLong idCounter = new AtomicLong();

    static {
        taskList.add(new Task(idCounter.incrementAndGet(), "Task One", "First task description"));
        taskList.add(new Task(idCounter.incrementAndGet(), "Task Two", "Second task description"));
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskList;
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskList.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Task not found with ID: " + taskId));
    }

    @PostMapping
    public Task createTask(@RequestBody Task newTask) {
        newTask.setId(idCounter.incrementAndGet());
        taskList.add(newTask);
        return newTask;
    }

    @DeleteMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        boolean removed = taskList.removeIf(task -> task.getId().equals(taskId));
        if (removed) {
            return "Task with ID " + taskId + " deleted successfully.";
        } else {
            throw new NoSuchElementException("Task not found with ID: " + taskId);
        }
    }
}
