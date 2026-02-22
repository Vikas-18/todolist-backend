package com.todo.todo_backend.service;

import com.todo.todo_backend.dto.TaskRequest;
import com.todo.todo_backend.dto.TaskResponse;
import com.todo.todo_backend.model.Task;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskRequest taskRequest);

    List<Task> getAllTasks();

    Task updateTask(String id, Task task);

    void deleteTask(String id);
}
