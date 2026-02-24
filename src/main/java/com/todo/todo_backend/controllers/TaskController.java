package com.todo.todo_backend.controllers;

import com.todo.todo_backend.dto.TaskRequest;
import com.todo.todo_backend.dto.TaskResponse;
import com.todo.todo_backend.model.Task;
import com.todo.todo_backend.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> create(
            @Valid @RequestBody TaskRequest request) {

        TaskResponse response = taskService.createTask(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable String id,
                       @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        taskService.deleteTask(id);
    }
}

