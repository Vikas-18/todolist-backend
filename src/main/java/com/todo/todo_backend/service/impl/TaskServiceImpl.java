package com.todo.todo_backend.service.impl;

import com.todo.todo_backend.dto.TaskRequest;
import com.todo.todo_backend.dto.TaskResponse;
import com.todo.todo_backend.model.Task;
import com.todo.todo_backend.repository.TaskRepository;
import com.todo.todo_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskResponse createTask(TaskRequest request)
    {
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .completed(request.isCompleted())
                .createdAt(LocalDateTime.now())
                .build();
        Task saved = taskRepository.save(task);
        return mapToResponse(saved);
    }
    private TaskResponse mapToResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.isCompleted())
                .createdAt(task.getCreatedAt())
                .build();
    }


    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(String id, Task updatedTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

}
