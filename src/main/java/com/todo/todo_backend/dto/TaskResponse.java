package com.todo.todo_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskResponse {

    private String id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
}
