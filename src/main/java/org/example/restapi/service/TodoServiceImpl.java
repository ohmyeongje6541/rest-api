package org.example.restapi.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.request.TodoCreateRequestDto;
import org.example.restapi.dto.request.TodoUpdateRequest;
import org.example.restapi.dto.response.TodoResponse;
import org.example.restapi.entity.Todo;
import org.example.restapi.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    @Transactional
    public TodoResponse create(TodoCreateRequestDto request) {
        Todo todo = Todo.builder()
            .title(request.getTitle())
            .content(request.getContent())
            .build();

        Todo saved = todoRepository.save(todo);
        return TodoResponse.from(saved);
    }

    @Override
    public List<TodoResponse> findAll() {
        return todoRepository.findAll().stream()
            .map(TodoResponse::from)
            .toList();
    }

    @Override
    public TodoResponse findById(Long id) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow();
        return TodoResponse.from(todo);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException();
        }
        todoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public TodoResponse update(Long id, TodoUpdateRequest request) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow();
        todo.update(request.getTitle(), request.getContent());
        return TodoResponse.from(todo);
    }
}
