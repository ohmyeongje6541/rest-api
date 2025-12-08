package org.example.restapi.service;

import jakarta.validation.Valid;
import java.util.List;
import org.example.restapi.dto.request.TodoCreateRequestDto;
import org.example.restapi.dto.request.TodoUpdateRequest;
import org.example.restapi.dto.response.TodoResponse;

public interface TodoService {
    TodoResponse create(TodoCreateRequestDto request);
    List<TodoResponse> findAll();
    TodoResponse findById(Long id);
    void delete(Long id);
    TodoResponse update(Long id, TodoUpdateRequest request);
}
