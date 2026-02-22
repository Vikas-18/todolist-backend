package com.todo.todo_backend.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;

    private String title;
    private String description;

    private boolean completed;

    private LocalDateTime createdAt;
}
