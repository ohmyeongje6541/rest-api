package org.example.restapi.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.example.restapi.entity.Todo;

@Getter
@Builder
public class TodoResponse {
    private Long id;
    private String title;
    private String content;
    private boolean completed;
    private LocalDateTime createdAt;

    public static TodoResponse from(Todo todo) {
        return TodoResponse.builder()
            .id(todo.getId())
            .title(todo.getTitle())
            .content(todo.getContent())
            .completed(todo.isCompleted())
            .createdAt(todo.getCreatedAt())
            .build();
    }
}
